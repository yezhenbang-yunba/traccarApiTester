package org.traccarApiTester;

import io.restassured.response.Response;
import org.traccarApiTester.helper.Log;

import static io.restassured.RestAssured.given;

public class DeviceTester extends BaseTester {

    public DeviceTester() {
        Log.start("api/devices");
        Response response =
                given().header("cookie", sessionId).
                when().get(baseUrl + "/api/devices").
                then().statusCode(200).
                extract().response();
        Log.response(response);
        Log.end("api/devices");
    }
}
