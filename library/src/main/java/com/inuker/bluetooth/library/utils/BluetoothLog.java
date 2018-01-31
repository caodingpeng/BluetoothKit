package com.inuker.bluetooth.library.utils;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by dingjikerbo on 2015/12/16.
 */
public class BluetoothLog {
    private static final String LOG_TAG = "MICO.ble";
    //private static final Logger logger = XLog.t(LOG_TAG).build();
    public static void i(String msg) {
        sLog.i(msg);
    }

    public static void e(String msg) {
        sLog.e(msg);
    }

    public static void v(String msg) {
        sLog.v(msg);
    }

    public static void d(String msg) {
        sLog.d(msg);
    }

    public static void w(String msg) {
        sLog.w(msg);
    }

    public static void e(Throwable e) {
        e(getThrowableString(e));
    }

    public static void w(Throwable e) {
        w(getThrowableString(e));
    }

    public static void setLogHandler(LogHandler logHandler){
        sLog = logHandler;
    }

    private static LogHandler sLog = getDefaultHandler();

    private static LogHandler getDefaultHandler(){
        return new LogHandler(){
            public void i(String msg) {
                Log.i(LOG_TAG, msg);
            }

            public void e(String msg) {
                Log.e(LOG_TAG, msg);
            }

            public void v(String msg) {
                Log.v(LOG_TAG, msg);
            }

            public void d(String msg) {
                Log.d(LOG_TAG, msg);
            }

            public void w(String msg) {
                Log.w(LOG_TAG, msg);
            }

            public void e(Throwable e) {
                e(getThrowableString(e));
            }

            public void w(Throwable e) {
                w(getThrowableString(e));
            }
        };
    }

    public static interface LogHandler{
        void i(String msg);
        void e(String msg);
        void v(String msg);
        void d(String msg);
        void w(String msg);
        void e(Throwable e);
        void w(Throwable e);
    }

    private static String getThrowableString(Throwable e) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);

        while (e != null) {
            e.printStackTrace(printWriter);
            e = e.getCause();
        }

        String text = writer.toString();

        printWriter.close();

        return text;
    }
}
