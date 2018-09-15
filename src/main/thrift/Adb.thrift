namespace java com.dreilly.adb.thrift

typedef i32 int

exception AdbException {
    1: string description
}

service AdbService {
    int get(1:string id) throws (1: AdbException ex),
    void put(1:string id, 2:int value) throws (1: AdbException ex),
}