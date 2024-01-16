package org.andrey.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * 3.1 Проверить, что в ответе на запрос GET количество элементов массива равно ожидаемому значению.
 * Необходимо выполнить запрос, который получает все игры пользователя
 * Затем необходимо добавить пользователю добавить еще одну игру
 * И после этого перепроверить, что количество элементо в  массиве увеличилось на  одну игру
 * Для авторизации использовать отдельный  запрос(там  есть ньюанс, если сами не  додумаетесь,
 * много времени не  тратьте,  приходите, подскажу )
 *
 * 3.2 Задача: Проверить, что в ответе на запрос DELETE отсутствует определенное поле.
 * удалить добавленную игру
 * проверить, что есть сообщение, что игра удалена
 * проверить, что в поле ответа нет поля id
 */

public class Task3Test {
    private static String authToken;
    private static String URL;
    private static RequestSpecification requestSpec;
    private static int gameId;

    @BeforeClass
    public static void setup() {
        authToken = SetupBeforeClassUtil.getToken();
        URL = SetupBeforeClassUtil.getUrl();
        requestSpec = Specification.requestSpecification(URL, ContentType.JSON);
    }

    @Test
    public void checkArrayOnExpectedSize() throws IOException {
        int initialSize = getGamesListSize();

        addUserGame();

        int newSize = getGamesListSize();
        assertEquals("Size should increase by 1", initialSize + 1, newSize);
    }
    @Test
    public void deleteGame() {

        given()
                .spec(requestSpec)
                .auth()
                .oauth2(authToken)
                .when()
                .delete("/api/user/games/{id}",gameId) // Используем статическое поле gameId
                .then()
                .body("info.message", equalTo("Game successfully deleted"))
                .body("info", not("id"));
    }

    private int getGamesListSize() {
        return given()
                .spec(requestSpec)
                .auth()
                .oauth2(authToken)
                .when()
                .get("/api/user/games")
                .then()
                .extract()
                .jsonPath()
                .getList("")
                .size();
    }

    private void addUserGame() throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/addGameJson.txt")));
        Response response = given()
                .spec(requestSpec)
                .auth()
                .oauth2(authToken)
                .contentType(ContentType.JSON)
                .body(jsonContent)
                .when()
                .post("/api/user/games")
                .then().log().all()
                .statusCode(201)
                .extract()
                .response();

        gameId = response.jsonPath().getInt("register_data.gameId");
    }

}