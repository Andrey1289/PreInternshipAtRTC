package org.andrey.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * 5. Задача:Проверить, что в ответе на запрос GET значение определенного поля равно ожидаемому значению.
 * выполнить запрос по пользователю, убедится, что  в поле  ответа приходит измененный пароль
 */
public class Task5Test {
    private static String URL  ;
    private static String authToken;

    @BeforeClass
    public static void setup()  {
        authToken = SetupBeforeClassUtil.getToken();
        URL = SetupBeforeClassUtil.getUrl();
    }
    @Test
    public void checkFieldOnExpectedValue(){
        Specification.installSpecification(Specification.requestSpecification(URL, ContentType.JSON),
                Specification.responseSpecification(200));
        Response response = given()
                .auth()
                .oauth2(authToken)
                .when()
                .get("/api/user")
                .then()
                .extract().response();
        Assert.assertEquals(SetupBeforeClassUtil.getProperties().getProperty("user.pass"),response.jsonPath().getString("pass"));
    }
}
