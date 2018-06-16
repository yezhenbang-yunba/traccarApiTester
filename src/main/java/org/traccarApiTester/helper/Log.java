package org.traccarApiTester.helper;

import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class Log {

    static Logger logger = Logger.getLogger("traccarApiTester");

    public static void error(String str) {
        logger.error(str);
    }
    public static void info(String str) {
        logger.info(str);
    }
    public static void debug(String str) {
        logger.debug(str);
    }

    public static void start(String str) {
        info("Start testing " + str + "...");
    }
    public static void end(String str) {
        info("Finish testing " + str + ": OK");
    }

    public static Response response(Response response) {
        debug(response.getBody().print());
        return response;
    }
}
