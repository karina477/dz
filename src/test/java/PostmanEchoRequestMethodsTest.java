import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoRequestMethodsTest {
    private static final String RAW_BODY = "This is expected to be sent back as part of response body.";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("GET Request - Check status code and all response body fields")
    void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'accept-encoding'", containsString("gzip"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'user-agent'", containsString("Apache-HttpClient/"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @DisplayName("POST Raw Text")
    void testPostRawText() {
        given()
                .contentType("text/plain")
                .body(RAW_BODY)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(RAW_BODY))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'accept-encoding'", containsString("gzip"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'user-agent'", containsString("Apache-HttpClient/"))
                .body("headers.'content-length'", equalTo("58"))
                .body("headers.'content-type'", containsString("text/plain"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("POST Form Data")
    void testPostFormData() {
        Map<String, String> expectedForm = Map.of(
                "foo1", "bar1",
                "foo2", "bar2"
        );

        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(""))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(expectedForm))
                .body("json", equalTo(expectedForm))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'accept-encoding'", containsString("gzip"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'user-agent'", containsString("Apache-HttpClient/"))
                .body("headers.'content-length'", equalTo("19"))
                .body("headers.'content-type'", containsString("application/x-www-form-urlencoded"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("PUT Request")
    void testPutRequest() {
        given()
                .contentType("text/plain")
                .body(RAW_BODY)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(RAW_BODY))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'accept-encoding'", containsString("gzip"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'user-agent'", containsString("Apache-HttpClient/"))
                .body("headers.'content-length'", equalTo("58"))
                .body("headers.'content-type'", containsString("text/plain"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    @DisplayName("PATCH Request")
    void testPatchRequest() {
        given()
                .contentType("text/plain")
                .body(RAW_BODY)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(RAW_BODY))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'accept-encoding'", containsString("gzip"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'user-agent'", containsString("Apache-HttpClient/"))
                .body("headers.'content-length'", equalTo("58"))
                .body("headers.'content-type'", containsString("text/plain"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("DELETE Request")
    void testDeleteRequest() {
        given()
                .contentType("text/plain")
                .body(RAW_BODY)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(RAW_BODY))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'accept-encoding'", containsString("gzip"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'user-agent'", containsString("Apache-HttpClient/"))
                .body("headers.'content-length'", equalTo("58"))
                .body("headers.'content-type'", containsString("text/plain"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
