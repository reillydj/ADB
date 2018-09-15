package com.dreilly.adb;

import org.apache.thrift.TException;

public class AdbService implements com.dreilly.adb.thrift.AdbService.Iface {

    public int get(String id) throws TException {
        return 2;
    }

    public void put(String id, int value) throws TException {
        
    }

}
