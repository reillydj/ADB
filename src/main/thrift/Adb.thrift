namespace java com.dreilly.adb.thrift

typedef i32 int
service AdbService
{
    int get(1:string id),
    void put(1:string id, 2:int value),
}