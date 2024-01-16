package org.andrey.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import static io.restassured.RestAssured.given;

/**
 * 4. Задача: Проверить, что в ответе на запрос PUT значение определенного поля было изменено.
 * поменять пароль пользователя, проверить ответ
 */
public class Task4Test {
    private static String URL  ;
    private static String authToken;

   @BeforeClass
    public static void setup() {

       authToken = SetupBeforeClassUtil.getToken();
       URL = SetupBeforeClassUtil.getUrl();
    }
    @Test
    public void changePasswordAndCheckNewPassword(){
        Specification.installSpecification(Specification.requestSpecification(URL, ContentType.JSON),
                Specification.responseSpecification(200));
        String newPassword = "rwfs617577";

        UpdateUserPassword updatePassword = new UpdateUserPassword(newPassword);
        Response response = given()
                .auth()
                .oauth2(authToken)
                .body(updatePassword)
                .when()
                .put("/api/user")
                .then().log().all().extract().response();
         Properties properties = SetupBeforeClassUtil.getProperties();
        Assert.assertEquals("User password successfully changed", response.jsonPath().getString("info.message"));
        Assert.assertEquals("success", response.jsonPath().getString("info.status"));
        properties.setProperty("user.pass",newPassword);
       SetupBeforeClassUtil.saveProperties();

    }

    }

