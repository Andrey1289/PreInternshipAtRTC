package org.andrey.api;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * 2. Задача: Проверить, что в ответе на запрос POST содержится определенное поле.
 * необходимо создать пользователя (желательно сделать кейс таким, чтобы  его можно было воспроизвести несколько раз )
 * поверить, что приходит в ответе поля:
 * * логин
 * *пароль
 * *id
 * код ответа получаем 201
 * в ответе есть сообщение о том, что  пользователь создан
 */
public class Task2Test {
    private static String URL;
    @BeforeClass
    public static void setup() {
        URL = SetupBeforeClassUtil.getUrl();
    }

    @Test
    public void checkSameFieldWhenPostRequest() throws IOException {
        Specification.installSpecification(Specification.requestSpecification(URL, ContentType.JSON),
                Specification.responseSpecification(201));;
        Faker faker = new Faker();
        String login = faker.name().username();
        String pass = faker.internet().password();
        RegisterUser user = new RegisterUser(login, pass);

        Response response = given()
                .body(user)
                .when()
                .post("/api/signup")
                .then().statusCode(201)
                .body("register_data.id", notNullValue())
                .body("register_data.login", equalTo(login))
                .body("register_data.pass", equalTo(pass))
                .body("info.message", equalTo("User created"))
                .extract().response();
        Properties properties = SetupBeforeClassUtil.getProperties();
        properties.setProperty("user.login", response.jsonPath().getString("register_data.login"));
        properties.setProperty("user.pass", response.jsonPath().getString("register_data.pass"));
        SetupBeforeClassUtil.saveProperties();
    }
}
