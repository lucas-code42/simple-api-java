package api.prefeituras.respository;

import api.prefeituras.result.ResponseResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientRepository {

    private final Connection db;

    public ClientRepository(Connection db) {
        this.db = db;
    }

    public ResponseResult queryClient(String did) throws SQLException {
        ResponseResult result = new ResponseResult();
        String query = "SELECT user, password FROM REQUESTED_PREFECTURE WHERE domain = ?";

        PreparedStatement stmt = this.db.prepareStatement(query);
        try {
            stmt.setString(1, did);
            ResultSet resultQuery = stmt.executeQuery();

            while (resultQuery.next()) {
                result.setUser(resultQuery.getString("user"));
                result.setPassword(resultQuery.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result.setUser("");
            result.setPassword("");
        }

        System.out.println(result.getPassword());
        System.out.println(result.getUser());

        return result;
    }
}
