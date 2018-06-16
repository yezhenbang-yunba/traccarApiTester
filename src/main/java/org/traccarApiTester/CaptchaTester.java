package org.traccarApiTester;

import io.restassured.response.Response;
import org.traccarApiTester.helper.Log;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CaptchaTester extends BaseTester {

    public CaptchaTester() {
        String url = baseUrl + "/api/captcha";
        Log.start("api/captcha");
        Log.response(
                given().param("phone", user).
                when().get(url).
                then().body("status", equalTo("ok")).
                extract().response());
        Log.end("api/captcha");

        Log.start("api/captchaLogin");
        Response response =
                given().
                        params("phone", user, "captcha", "123456").
                when().
                        post(url).
                then().
                    statusCode(200).
                extract().response();
        Log.response(response);
        Log.end("api/captchaLogin");
        sessionId = response.getHeader("Set-Cookie").substring(response.getHeader("Set-Cookie").indexOf("JSESSIONID")).split(";")[0];
    }
}
