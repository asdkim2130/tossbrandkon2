package brandkon;

import brandkon.Product.ProductResponse;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void 상품목록조회() {
        RestAssured
                .given()
                .when()
                .get("/products") // 서버로 GET /products 요청
                .then()
                .statusCode(200); // 요청에 대한 서버 응답의 상태코드가 200인지 검증
    }

    @Test
    void 상품상세조회(){
        RestAssured
                .given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200);

    }

    @Test
    void 상품목록조회2(){
        RestAssured
                .given().log().all()
                .queryParam("brandId", "false")
                .when()
                .get("products/")
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList(".", ProductResponse.class);


    }



}