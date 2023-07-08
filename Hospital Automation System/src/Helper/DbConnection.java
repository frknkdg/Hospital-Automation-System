package Helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author furkan
 */
public class DbConnection {

    public DbConnection() {
    }

    
    public Connection conDb() {
        Connection con = null;
        String url = "jdbc:mariadb://localhost:3306/hospital";
        String user = "root";
        String pswd = "8169";

        try {
            con = DriverManager.getConnection(url, user, pswd);
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

}

