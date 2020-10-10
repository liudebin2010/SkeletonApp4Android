package com.v51das.android.skeletonapp.utils;

import android.util.Log;

/**
 * 日志封闭类，可以自由控制打印日志的级别
 * 当level=NOTHING时，可在发布app时屏蔽系统开时所打的日志
 */
public class LogUtil {

    public static final int VERBOSE=1;
    public static final int DEBUG=2;
    public static final int INFO=3;
    public static final int WARN=4;
    public static final int ERROR=5;
    public static final int NOTHING=6;

    public static int level=VERBOSE; //默认为VERBOSE级别

    public static void v(String tag,String msg){
        if (level<=VERBOSE){
            Log.v(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if (level<=DEBUG){
            Log.d(tag,msg);
        }
    }
    public static void i(String tag,String msg){
        if (level<=INFO){
            Log.i(tag,msg);
        }
    }
    public static void w(String tag,String msg){
        if (level<=WARN){
            Log.w(tag,msg);
        }
    }
    public static void e(String tag,String msg){
        if (level<=ERROR){
            Log.e(tag,msg);
        }
    }
}
