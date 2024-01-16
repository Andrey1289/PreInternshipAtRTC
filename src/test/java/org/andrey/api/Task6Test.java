package org.andrey.api;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * 6. Задача: Проверить, что в ответе на запрос DELETE статус код равен ожидаемому значению.
 * удалить созданного пользователя, проверить сообщение в ответе и статус код
 */

/**Коментарий в этот класс я добавил @AfterClass метод который
 * создает нового пользователя снова для того что бы тест не падал.
 *
 */
public class Task6Test {
    private static String URL;
    private static String authToken;

    @BeforeClass
    public static void setup() {
        authToken = SetupBeforeClassUtil.getToken();
        URL = SetupBeforeClassUtil.getUrl();
    }

    @Test
    public void checkResponseFromDeleteMethod() {
        int userStatusCode = given()
                .spec(Specification.requestSpecification(URL, ContentType.JSON))
                .auth()
                .oauth2(authToken)
                .when()
                .get("/api/user")
                .getStatusCode();

        if (userStatusCode == 200) {
            performUserDeletion();
        } else {
            System.out.println("User does not exist, skipping deletion.");
        }
    }

    private void performUserDeletion() {
        given()
                .spec(Specification.requestSpecification(URL, ContentType.JSON))
                .auth()
                .oauth2(authToken)
                .when()
                .delete("/api/user")
                .then()
                .assertThat()
                .statusCode(200)
                .body("info.status", equalTo("success"))
                .body("info.message", equalTo("User successfully deleted"));

    }
    @AfterClass
    public static void createUserAgain(){
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