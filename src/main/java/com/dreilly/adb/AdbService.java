package com.dreilly.adb;

import com.dreilly.adb.thrift.AdbException;
import org.apache.commons.lang3.StringUtils;

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

    public void put(String id, int value) throws AdbException {
        if (StringUtils.isBlank(id)) {
            throw new AdbException("Record id cannot be blank");
        } else {
            backing.put(id, value);
        }
    }
}