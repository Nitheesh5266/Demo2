package ApiTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserApiTest {

    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void testCreateUser() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String payload = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\" }";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Alice"))
            .body("email", equalTo("alice@example.com"));
    }
}