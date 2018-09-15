package com.dreilly.adb;

import com.dreilly.adb.thrift.AdbException;
import org.apache.thrift.TException;

import java.util.HashMap;
import java.util.Map;

public class AdbService implements com.dreilly.adb.thrift.AdbService.Iface {

    private static Map<String, Integer> backing;

    public AdbService() {
        backing = new HashMap<String, Integer>();
    }

    public int get(String id) throws AdbException {
        if (backing.containsKey(id)) {
            return backing.get(id);
        } else {
            throw new AdbException(String.format("Record not found: %s", id));
        }
    }

    public void put(String id, int value) {
        
    }

    public static void main(String[] args) {
        AdbService service = new AdbService();
        try {
            System.out.println(service.get("1"));
        } catch (TException e) {
            System.out.println("caught");
        }
    }

}
