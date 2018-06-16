package org.traccarApiTester;

import io.restassured.response.Response;
import org.traccarApiTester.helper.Log;

import static io.restassured.RestAssured.given;

public class PositionTest extends BaseTester {
    public PositionTest() {
        String url = baseUrl + "/api/position";
        Log.start("/api/position");
        Response response =
                given().headers("cookie", sessionId).
                param("deviceId", deviceId).
                when().get(url).
                then().statusCode(200).
                extract().response();
        Log.response(response);
        Log.end("api/position");
    }
}
