package api.prefeituras.infra;

import java.sql.*;

public class MysqlInfra {

    public Connection mysqlConnect() {
        try {
            String url = "jdbc:mysql://localhost:3306/java_application";
            String user = "root";
            String pass = "@Mr.robot!1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("dataBase is connected");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
