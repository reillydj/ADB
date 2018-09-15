package com.dreilly.adb;

public class Main {

    public static void main(String[] args) {
        Adb service = new Adb();

        service.start();
    }

}
