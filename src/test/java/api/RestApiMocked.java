package api;

import com.google.gson.Gson;
import dto.OrderDtoMocked;
import dto.OrderDtoMockedBuilderAndFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.RandomDataGenerator;

import static io.restassured.RestAssured.*;



public class RestApiMocked {
    private final String api_key = "1234567890123456";

}

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI ="http://35.208.34.242:8080";
     //   RestAssured.port =443;
    }


    @Test
    public void  getOrderByIdAndCheckResponseCodeIsOk(){
        get("test-orders/9")
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    @Test
    public void  getOrderByIdAndCheckResponseCodeIsBadRequest(){
        given().
                when().
                get("test-orders/9")
                .then()
                .log()
                .all()
                .statusCode(400);

    }
// Urok 9
    @Test
    public void  getOrderByIdAndCheckResponseCodeIs200t(){
        get("http://35.208.34.242:8080/test-orders/get_orders")
                .then()
                .statusCode(200);

}

// Home Work 9, point 1



    @Test
    public void deletingAnOrderIs204(){
        given().
                header("api_key", "1234567890123456").
                when().
                delete("http://35.208.34.242:8080/test-orders/1").
                then().
                statusCode(204);
    }

    @Test
    public void  deletingAnOrderIs404(){
        given().
                header("api_key", "1234567890123456").
                when().
                delete("test-orders/2")
                .then()
                .log()
                .all()
                .statusCode(404);

    }
    @Test
    public void  deletingAnOrderIsBadRequest(){
        given().
                header("api_key", "1234567890123456").
                when().
                delete("test-orders/22")
                .then()
                .log()
                .all()
                .statusCode(400);

    }
    @Test
    public void  deletingAnOrderIsUnauthorized(){
        given().
                header("api_key", "12ertert7890123456").
                when().
                delete("test-orders/2")
                .then()
                .log()
                .all()
                .statusCode(401);

    }

// Urok 10

    @ParameterizedTest
    @ValueSource(ints = {1,5,9,10})
    public void getOrdersByIdAndCheckResponseCodeIsOk(int orderId) {
        given().
                log()
                .all()
                .when()
                .get("/test-orders/" + orderId)
//                .get("/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 12})
    public void getOrdersByIdAndCheckResponseCodeIsNOk(int orderId) {
        given().
                log()
                .all()
                .when()
                .get("/test-orders/" + orderId)
//                .get("/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }



    @ParameterizedTest
    @ValueSource(ints = {1,5,9,10})
    public void getOrdersByIdAndCheckResponseCodeIsOkSecond(int orderId) {
        int responseOrderId=
                given().
                        log()
                        .all()
                        .when()
                        .get("/test-orders/" + orderId)
//                .get("/test-orders/{orderId}", orderId)
                        .then()
                        .log()
                        .all()
                        .statusCode(HttpStatus.SC_OK)
                        .and()
                        .extract()
                        .path("id");

        Assertions.assertEquals(orderId, responseOrderId);
    }
    // HOMEWORK 10
    @ParameterizedTest
    @CsvSource({
            "Peter1, Password01",
            "Maria2, Password02",
            "Tuuli3, Password03",
            "Ivan4, Password04"
    })
    public void testWithCsvSourceParameters(String username, String password){
        String response = given().
                log()
                .all()
                .when()
                .get("/test-orders?username=" + username+"&password="+ password)
//                .get("/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("apiKey");

        Assertions.assertNotNull(response);


    }
// UROK 11
@Test
public void createOrderAndCheckResponseCodeIsOk(){

    //  OrderDtoMocked orderDtoMocked = new OrderDtoMocked("OPEN", 0, "customer", "56554645", "hello", 0);

    OrderDtoMocked orderDtoMocked = new OrderDtoMocked();


    orderDtoMocked.setStatus("OPEN");
    orderDtoMocked.setCourierId(0);
    orderDtoMocked.setCustomerName(RandomDataGenerator.generateName());
    orderDtoMocked.setCustomerPhone("2423424");
    orderDtoMocked.setComment("comment");
    orderDtoMocked.setId(1);

    given().
            header("Content-Type", "application/json")
            .log()
            .all()
            .when()
            .body( new Gson().toJson(orderDtoMocked))
            .post("/test-orders")
            .then()
            .log()
            .all()
            .statusCode(HttpStatus.SC_OK);


    // Homework 11, point 2
    @Test

    public void changeOrderFieldNamesByUsingPutMethodAndStatusCodeShouldBeOk(){

        OrderDtoMocked orderDtoMocked = new OrderDtoMocked();

//            orderDtoMocked1.setCustomerName(RandomDataGenerator.generateName());
//            orderDtoMocked1.setCustomerPhone(RandomDataGenerator.generatePhone());
//            orderDtoMocked1.setComment(RandomDataGenerator.generateComment());
//            orderDtoMocked1.setId(5);
//            orderDtoMocked1.setStatus("ACCEPTED");
//            orderDtoMocked1.setCourierId(8);


        orderDtoMocked.setStatus("ACCEPTED");
        orderDtoMocked.setCourierId(0);
        orderDtoMocked.setCustomerName(RandomDataGenerator.generateName());
        orderDtoMocked.setCustomerPhone(RandomDataGenerator.generatePhone());
        orderDtoMocked.setComment(RandomDataGenerator.generateComment());
        orderDtoMocked.setId(0);

        given()
                .header("accept", "application/json")
                .header("api_key", api_key)
                .contentType((ContentType.JSON))
                .log().all()
                .when()
                .body(new Gson().toJson(orderDtoMocked))
                .put("/test-orders/{id}", id)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);


    }
    //// UROK 12
    @Test
    public void createOrderStatus(){



//        OrderDtoMockedBuilderAndFactory orderDtoMockedBuilderAndFactory =  OrderDtoMockedBuilderAndFactory.builder()
//                .status("OPEN")
//                .courierId(0)
//                .customerName(RandomDataGenerator.generateName())
//                .customerPhone("2423424")
//                .comment("comment")
//                .id(1)
//                .build();



//        orderDtoMocked.setStatus("OPEN");
//        orderDtoMocked.setCourierId(0);
//        orderDtoMocked.setCustomerName(RandomDataGenerator.generateName());
//        orderDtoMocked.setCustomerPhone("2423424");
//        orderDtoMocked.setComment("comment");
//        orderDtoMocked.setId(1);

        //OrderDtoMockedBuilderAndFactory orderDtoMockedBuilderAndFactory = OrderDtoMockedBuilderAndFactory.createRandomOrder();

        Gson gson = new Gson();

        OrderDtoMockedBuilderAndFactory orderDtoMockedBuilderAndFactory = OrderDtoMockedBuilderAndFactory.createRandomOrder();

        Response response= given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body( new Gson().toJson(orderDtoMockedBuilderAndFactory))
                .post("/test-orders")
                .then()
                .extract()
                .response();
        //deserialization
        OrderDtoMocked orderReceived = gson.fromJson(response.asString(), OrderDtoMocked.class);
        Assertions.assertEquals("OPEN", orderReceived.getStatus());
        Assertions.assertEquals(orderDtoMockedBuilderAndFactory.getCustomerName(), orderReceived.getCustomerName());

    }


    }








