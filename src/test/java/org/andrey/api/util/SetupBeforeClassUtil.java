package org.andrey.api.util;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.andrey.api.pojo.UserToken;

import java.io.*;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SetupBeforeClassUtil {
    private static final String URL_PROPERTY_KEY = "URL";
    private static final String LOGIN_PROPERTY_KEY = "user.login";
    private static final String PASSWORD_PROPERTY_KEY = "user.pass";
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/userInfo.properties";
    private static final Properties properties = new Properties();
    private static String token;

    static {
            loadProperties();
            setupRestAssuredConfig();

    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties from file: " + PROPERTIES_FILE_PATH, e);
        }
    }
    public static Properties getProperties(){
        return properties;
    }

    public static String getUrl() {
        return properties.getProperty(URL_PROPERTY_KEY);
    }

    public static String getToken()  {
        if (token == null || token.isEmpty()) {
            String userName = properties.getProperty(LOGIN_PROPERTY_KEY);
            String password = properties.getProperty(PASSWORD_PROPERTY_KEY);
            UserToken user = new UserToken(password, userName);
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(user)
                    .when()
                    .post(getUrl() + "/api/login");
            if (response.getStatusCode() == 200) {
                token = response.jsonPath().getString("token");
            } else {
                throw new IllegalStateException("Failed to obtain token. Status code: " + response.getStatusCode());
            }
        }
        return token;
    }

    public static void saveProperties() {
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE_PATH)) {
            properties.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException("Error saving properties from file: " + PROPERTIES_FILE_PATH, e);
        }
    }

    private static void setupRestAssuredConfig() {
        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
    }
}
