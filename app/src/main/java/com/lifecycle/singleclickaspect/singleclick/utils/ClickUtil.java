package com.lifecycle.singleclickaspect.singleclick.utils;

import android.view.View;

public final class ClickUtil {
    /**
     * 最近一次点击时间
     */
    private static long mLastClickTime;

    /**
     * 最近一次点击的控件id
     */
    private static int mLastClickViewId;

    public static boolean isFastDoubleClick(View v, long intervalMillis) {
        int viewId = v.getId();
        long time = System.currentTimeMillis();
        long timeInterval = Math.abs(time - mLastClickTime);
        if (timeInterval < intervalMillis && viewId == mLastClickViewId) {
            return true;
        } else {
            mLastClickTime = time;
            mLastClickViewId = viewId;
            return false;
        }
    }


}
