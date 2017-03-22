package com.jusenr.socialcontactappdemo;

/**
 * Created by T5-Jusenr on 2017/3/22.
 */

public class NativeTest {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    // Example of a call to a native method

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
