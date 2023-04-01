package sky.project.models.dao;

import sky.project.models.models.City;

import java.sql.SQLException;

public interface CityDAO {
    City findById(Integer id) throws SQLException;
}
