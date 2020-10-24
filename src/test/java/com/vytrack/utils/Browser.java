package com.vytrack.utils;

public class Browser {

    public static void wait(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            System.out.println("Browser.wait: time out error");
        }
    }
}
