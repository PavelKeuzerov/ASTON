package lesson_16;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    @DisplayName("Method testing 'GET'")
    public void checkGetTest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then().log().body()
                .statusCode(200)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    @DisplayName("Method testing 'POST'")
    public void checkPostTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Some raw text")
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("13"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Method testing 'PUT'")
    public void checkPutTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Some raw text")
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("13"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    @DisplayName("Method testing 'DELETE'")
    public void checkDeleteTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Some raw text")
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("13"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }

}
