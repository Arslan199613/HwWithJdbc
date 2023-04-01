package sky.project.models.dao;

import sky.project.models.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee findEmployeeById(Integer id) throws SQLException;

    void addEmployee(Employee employee) throws SQLException;

    List<Employee> getAll() throws SQLException;

    void update(Integer id, Integer age);

    void deleteById(Integer id);
}
