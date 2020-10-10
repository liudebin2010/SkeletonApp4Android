package com.v51das.android.skeletonapp.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动管理类
 */
public class ActivityMgrUtil {

    // 用于存放Activity的列表
    public static List<Activity> activityList = new ArrayList<>();

    /**
     * 添加Activity到列表
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 从列表中移除Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    /**
     * 销毁列表中所有的Activity
     */
    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
