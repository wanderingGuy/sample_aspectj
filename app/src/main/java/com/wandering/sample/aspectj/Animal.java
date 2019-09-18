package com.wandering.sample.aspectj;

import android.util.Log;

public class Animal {
    private static final String TAG = "Animal";

    public void fly() {
        Log.e(TAG, "animal fly method:" + this.toString() + "#fly");
    }

    public void run(int speed) {
        Log.e(TAG, "animal run method speed:" + speed);
    }

    public int getName(String name) {
        return name.length();
    }

    public boolean setAge(int age) {
        Log.e(TAG, "setAge age:" + age);
        return true;
    }
}