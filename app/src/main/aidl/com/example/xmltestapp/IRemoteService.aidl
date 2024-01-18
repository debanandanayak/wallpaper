// IRemoteService.aidl
package com.example.xmltestapp;

// Declare any non-default types here with import statements

interface IRemoteService {
    String getName();
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}