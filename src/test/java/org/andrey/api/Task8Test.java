package org.andrey.api;

import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.io.File;
import io.restassured.http.ContentType;

/**
 * 8.Задача. Загрузить файл на сервер
 * выполнить запрос по загрузке файла,  проверить статус ответа
 */

public class Task8Test {
    private static String URL;
    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void setup() {
        URL = SetupBeforeClassUtil.getUrl();
        requestSpec = Specification.requestSpecification(URL, ContentType.MULTIPART);
    }

    @Test
    public void shouldUploadFileSuccessfully() {
        File fileUpload = new File("src/test/resources/UploadFile.txt");
        assertTrue("Error: File does not exist.", fileUpload.exists());
        uploadFile(fileUpload);
    }

    private void uploadFile(File file) {
        given()
                .spec(requestSpec)
                .multiPart(file)
                .when()
                .post("/api/files/upload")
                .then()
                .assertThat().statusCode(200);
    }
}