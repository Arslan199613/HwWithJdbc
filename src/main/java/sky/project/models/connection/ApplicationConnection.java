package sky.project.models.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnection {
    public static void main(String[] args) {

    }
    private static Connection getConnection() throws SQLException {
        final String url="jdbc:postgresql://localhost:5433/newbase";
        final String user= "postgres" ;
        final String password="1996Arslan";

        return DriverManager.getConnection(url, user, password);

    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}

