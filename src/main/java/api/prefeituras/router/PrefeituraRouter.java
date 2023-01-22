package api.prefeituras.router;

import api.prefeituras.controller.ClientController;
import api.prefeituras.result.ResponseResult;
import api.prefeituras.result.UnauthorizedResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/v1/prefecture/")
public class PrefeituraRouter {

    @GetMapping("/client/{did}")
    public ResponseEntity<?> getUserAndPassword(
            @PathVariable String did,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws SQLException {
        if (!token.equals("cca69230-b194-478b-9618-890c639e2cec")) {
            return ResponseEntity.badRequest().body(new UnauthorizedResult());
        } else {
            System.out.println(did);
            ResponseResult query = new ClientController().getClientUserAndPass(did);
            return ResponseEntity.ok(query);
        }

    }
}
