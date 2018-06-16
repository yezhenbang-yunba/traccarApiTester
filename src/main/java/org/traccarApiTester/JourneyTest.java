package org.traccarApiTester;

import io.restassured.response.Response;
import org.traccarApiTester.helper.Log;

import static io.restassured.RestAssured.given;

public class JourneyTest extends BaseTester {
    public JourneyTest() {
        Log.start("/api/journeys");
        Response response =
                given().header("cookie", sessionId).
                        param("deviceId",743).
                        when().get(baseUrl + "/api/journeys").then().statusCode(200).extract().response();
        Log.response(response);
        Log.end("api/journeys");
    }
}
