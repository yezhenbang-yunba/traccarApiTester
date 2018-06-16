package org.traccarApiTester;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class BaseTester {
    static String baseUrl;
    static long deviceId;
    static long interval;
    static String user;
    static String phone;
    static String sessionId;
    static boolean doLogin,doDevice,doJourney,doPosition;

    BaseTester() {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseUrl = properties.getProperty("host");
        deviceId = Long.parseLong(properties.getProperty("deviceId"));
        user = properties.getProperty("user");
        phone = properties.getProperty("phone");
        interval = Long.parseLong(properties.getProperty("interval"));
        doLogin = Boolean.parseBoolean(properties.getProperty("LoginAPI"));
        doDevice = Boolean.parseBoolean(properties.getProperty("DeviceAPI"));
        doJourney = Boolean.parseBoolean(properties.getProperty("JourneyAPI"));
        doPosition = Boolean.parseBoolean(properties.getProperty("PositionAPI"));
    }
}
