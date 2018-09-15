package com.dreilly.adb.client;

import com.dreilly.adb.thrift.AdbService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class AdbThriftClient {
    public static void main(String [] args) {


        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            AdbService.Client client = new AdbService.Client(protocol);

            perform(client);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(AdbService.Client client) throws TException
    {
        client.put("1", 3);
        client.put("2", 5);
        int product = client.get("2");
        System.out.println("id=" + product);
    }
}
