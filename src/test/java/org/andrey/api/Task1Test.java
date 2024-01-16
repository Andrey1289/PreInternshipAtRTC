package org.andrey.api;


import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * 1. Задача: Проверить статус код ответа на запрос GET.
 * - взять метод, который получает код 200
 * - взять метод, у которого мы ожидаем ошибку
 */
public class Task1Test {
    private static String URL;
    @BeforeEach
    public  void setup() {
        URL = SetupBeforeClassUtil.getUrl();
    }
    @Test
    public void checkStatus200(){
        List<Object> users = given()
                .contentType(ContentType.JSON)
                .when()
                .get(URL+"/api/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().body().jsonPath().get();
        Assert.assertNotNull(users);
    }
    @Test
    public void checkStatus401(){
        given()
                .when()
                .get(URL+"/api/user")
                .then()
                .assertThat()
                .statusCode(401);
    }
}
