package api.prefeituras.controller;

import api.prefeituras.infra.MysqlInfra;
import api.prefeituras.respository.ClientRepository;
import api.prefeituras.result.ResponseResult;
import java.sql.Connection;
import java.sql.SQLException;

public class ClientController {

    public ResponseResult getClientUserAndPass(String did) throws SQLException {
        System.out.printf("Dentro de controller %s", did);
        MysqlInfra connection = new MysqlInfra();
        Connection conn = connection.mysqlConnect();

        ResponseResult result = new ClientRepository(conn).queryClient(did);

        try {
            conn.close();
            System.out.println("connection is closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }
}
