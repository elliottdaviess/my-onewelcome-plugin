package com.admiral.nextgen;

import android.util.Log;

public class MyOneWelcomePlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
