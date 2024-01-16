package org.andrey.api;

import io.restassured.http.ContentType;
import org.andrey.api.util.SetupBeforeClassUtil;
import org.andrey.api.util.Specification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static io.restassured.RestAssured.given;

/**
 * 7. Задача. Скачать картинку с сервера в формате JPEG
 * выполнить запрос,  проверить статус ответа, сохранить  файл
 */
public class Task7Test {
    private static String URL;
    private static String DOWNLOAD_PATH = "src/test/resources/downloadFile.jpeg";

    @BeforeEach
    public void setup() {
        URL = SetupBeforeClassUtil.getUrl();
    }

    @Test
    public void downloadPageCheckStatusSaveFile() {
        Specification.installSpecification(Specification.requestSpecification(URL, ContentType.JSON),
                Specification.responseSpecification(200));
        byte[] byteArray = given()
                .when()
                .get("/api/files/download")
                .then()
                .contentType("application/octet-stream")
                .assertThat()
                .extract().asByteArray();

        if (byteArray != null) {
            saveImageToFile(byteArray, DOWNLOAD_PATH);
        } else {
            System.out.println("Error: Downloaded data is null.");
        }
    }

    public static void saveImageToFile(byte[] bytes, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            fos.write(bytes);
            System.out.println("Image saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}