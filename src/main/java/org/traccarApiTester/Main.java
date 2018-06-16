package org.traccarApiTester;

import org.traccarApiTester.helper.Log;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new BaseTester();
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                if (BaseTester.doLogin)
                    new CaptchaTester();
                if (BaseTester.doDevice)
                    new DeviceTester();
                if (BaseTester.doJourney)
                    new JourneyTest();
                if (BaseTester.doPosition)
                    new PositionTest();
            } catch (AssertionError e) {
                e.printStackTrace();
                Log.error(e.getMessage() + e.getStackTrace()[e.getStackTrace().length - 2].toString());
                try {
                    Process process = Runtime.getRuntime().exec("sudo service traccar restart");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } finally {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
