package sky.project.models.dao;

import sky.project.models.models.City;
import sky.project.models.connection.ApplicationConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAOImpl implements CityDAO {
    private ApplicationConnection applicationConnection = new ApplicationConnection();

    @Override
    public City findById(Integer id) throws SQLException {
        try(PreparedStatement statement=
                    applicationConnection.getPreparedStatement("SELECT * FROM city WHERE city_id=(?)")){
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new City(resultSet.getString("city_name"));
        }
    }
}
