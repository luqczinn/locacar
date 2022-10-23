/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package locadora.locadora.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gugup
 */
public class conexao {

    private Connection con = null;

    private String hostName = null;
    private String userName = null;
    private String password = null;
    private String url = null;
    private String jdbcDriver = null;
    private String dataBaseName = null;
    private String dataBasePrefix = null;
    private String dabaBasePort = null;

    public conexao() {
        super();
        hostName = "locacarbd.cjpzfmkc7gea.us-east-1.rds.amazonaws.com";
        userName = "admin";
        password = "NFe8Y6Nh7OPZEfh^sW3hv";
        jdbcDriver = "com.mysql.jdbc.Driver";
        dataBaseName = "bdlocacar";
        dataBasePrefix = "jdbc: mysql://";
        dabaBasePort = "3306";

        url = dataBasePrefix + hostName + ":" + dabaBasePort + "/" + dataBaseName + "/";
    }

    public Connection getConnection() {
        try {
            if (con == null) {
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, userName, password);
            } else if (con.isClosed()) {
                con = null;
                return getConnection();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
