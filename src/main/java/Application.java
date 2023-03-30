import sky.project.models.dao.CityDAO;
import sky.project.models.dao.CityDAOImpl;
import sky.project.models.dao.EmployeeDAO;
import sky.project.models.dao.EmployeeDAOImpl;
import sky.project.models.models.City;
import sky.project.models.models.Employee;

import java.sql.SQLException;

public class Application {
    private static CityDAO cityDAO =new CityDAOImpl();
    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public static void main(String[] args) throws SQLException {

        //Добавление работника.
       employeeDAO.addEmployee(new Employee("Михаил", "Васильев", 40, new City(1)));
        //Получение работника по ID
       System.out.println(employeeDAO.findEmployeeById(10));
        //Получение списка работников
       System.out.println(employeeDAO.getAll());
        //Обновление данных по id
        employeeDAO.update(1, 60);
        //Удаление данных по id
        employeeDAO.deleteById(8);

    }
}