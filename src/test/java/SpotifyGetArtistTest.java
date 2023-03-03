import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpotifyGetArtistTest {
    private static final Logger logger = LogManager.getLogger(SpotifyGetArtistTest.class);

    @Test
    public void getArtistsTest() throws IOException {

        String spotifyApiKey = "src/test/config.properties";
        FileInputStream propsInput = new FileInputStream(spotifyApiKey);

        Properties prop = new Properties();
        prop.load(propsInput);


        // Map<String, String> params = new HashMap<>()["ids", "2w9zwq3AktTeYYMuhMjju8"]
        logger.info("Get Artists Test");
        Response response = RestAssured.given()
                .param("ids", "1Li0eIWeMeWcOOWpImcG9H")
                .header("X-RapidAPI-Key",
                  prop.getProperty("X_Spotify_RapidApi_Key"))
                .header("X-RapidAPI-Host", "spotify23.p.rapidapi.com")
                .get("https://spotify23.p.rapidapi.com/artists/")
                .then()
                .contentType(ContentType.JSON)
                //.body("id", contains("1Li0eIWeMeWcOOWpImcG9H"))
                .extract().response();

        response.getBody().prettyPrint();

        assertThat(response.getStatusCode(), equalTo(200));

    }

}
