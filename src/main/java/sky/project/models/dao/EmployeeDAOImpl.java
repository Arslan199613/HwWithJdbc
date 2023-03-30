package sky.project.models.dao;

import sky.project.models.connection.ApplicationConnection;
import sky.project.models.models.City;
import sky.project.models.models.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private ApplicationConnection applicationConnection = new ApplicationConnection();

    @Override
    public Employee findEmployeeById(Integer id) throws SQLException {
        Employee employee = new Employee();
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement("SELECT * FROM employees INNER JOIN city ON employees.city_id=city.city_id AND id=(?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(new City(resultSet.getString("city_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPreparedStatement(
                "INSERT INTO employees(first_name,last_name,age,city_id) VALUES((?),(?),(?),(?))")) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setInt(3, employee.getAge());
            statement.setInt(4, employee.getCity().getId());

            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement statement = applicationConnection.getPreparedStatement(
                "SELECT * FROM employees INNER JOIN city ON employees.city_id=city.city_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String firstName = resultSet.getString("last_name");
                Integer age = resultSet.getInt("age");
                City city = (new City(resultSet.getString("city_name")));

                employeeList.add(new Employee(name, firstName, age, city));
            }
            employeeList.add(new Employee());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void update(Integer id, Integer age) {
        try (PreparedStatement statement = applicationConnection.getPreparedStatement(
                "UPDATE employees SET age=(?) WHERE id=(?)")) {

            statement.setInt(1, age);
            statement.setInt(2, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement statement = applicationConnection.getPreparedStatement(
                "DELETE FROM employees WHERE id=(?)")) {

            statement.setInt(1, id);
            statement.executeQuery();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


