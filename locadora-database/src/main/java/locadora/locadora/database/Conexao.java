package locadora.locadora.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    static Connection con = null;
    static String hostName = "locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com";
    static String userName = "admin";
    static String password = "NFe8Y6Nh7OPZEfh^sW3hv";
    static String jdbcDriver = "com.mysql.jdbc.Driver";
    static String dataBaseName = "bdlocacar";
    static String dataBasePrefix = "jdbc:mysql://";
    static String dabaBasePort = "3306";

    static String url  = dataBasePrefix + hostName + ":" + dabaBasePort + "/" + dataBaseName + "/";

    public static Connection getConnection() {
        try {
            if (con == null) {
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, userName, password);
            } else if (con.isClosed()) {
                con = null;
                return getConnection();
            }
        } catch (ClassNotFoundException e) {

            //TODO: use um sistema de log apropriado.
            e.printStackTrace();
        } catch (SQLException e) {

            //TODO: use um sistema de log apropriado.
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
            }
        }
    }
}
