package api;

import com.google.gson.Gson;
import dto.LoginDto;
import dto.OrderDtoMocked;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import utils.RandomDataGenerator;

import static io.restassured.RestAssured.given;

public class LoginTest {
    @Test
    public void successfulLoginWithCorrectLoginPassword(){


        LoginDto loginDto = new LoginDto( "nadezhda", "p32V7aYbfT2n");

        String response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .when()
                .body( new Gson().toJson(loginDto))
                .post("http://35.208.34.242:8080/login/student")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .asString();


    }
    @Test
    public void unSuccessfulLoginWithCorrectLoginPassword(){


        LoginDto loginDto = new LoginDto( "nadezhda", "");

        String response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .when()
                .body( new Gson().toJson(loginDto))
                .post("http://35.208.34.242:8080/login/student")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .extract()
                .asString();


    }
}
