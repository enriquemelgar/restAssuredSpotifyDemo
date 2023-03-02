import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpotifyGetArtistTest {
    private static final Logger logger = LogManager.getLogger(SpotifyGetArtistTest.class);

    @Test
    public void getArtistsTest() {

        // Map<String, String> params = new HashMap<>()["ids", "2w9zwq3AktTeYYMuhMjju8"]
        logger.info("Get Artists Test");
        Response response = RestAssured.given()
                .param("ids", "1Li0eIWeMeWcOOWpImcG9H")
                .header("X-RapidAPI-Key",
                        "8a1d5b91f6mshdfa0c46b1561988p116a45jsnfb72c7ad0d0e")
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
