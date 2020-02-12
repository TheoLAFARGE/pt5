import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class param {
    private Connection con;
    public param() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return con;
    }

}
