package com.dreilly.adb;

import com.dreilly.adb.thrift.AdbService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class Adb {

    static AdbThriftIFace handler;
    static AdbService.Processor processor;

    public void start() {

        handler = new AdbThriftIFace();
        processor = new AdbService.Processor(handler);
    try {
        Runnable simple = new Runnable() {
            public void run() {
                simple(processor);
            }
        };

        new Thread(simple).start();
    } catch (Exception x) {
        x.printStackTrace();
    }
    }

    static void simple(AdbService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}