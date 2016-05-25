package com.jzg.erp.app;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.Stack;

/**
 * @author: voiceofnet
 * email: pengkun@jingzhengu.com
 * phone:18101032717
 * @time: 2016/5/23 14:18
 * @desc:
 */
public class JzgApp extends Application {
    private static JzgApp app;
    private Stack<Activity> actStack;
    /**
     * 主线程ID
     */
    private static int mMainThreadId = -1;
    /**
     * 主线程ID
     */
    private static Thread mMainThread;
    /**
     * 主线程Handler
     */
    private static Handler mMainThreadHandler;
    /**
     * 主线程Looper
     */
    private static Looper mMainLooper;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();
        Fresco.initialize(this);
    }

    public static JzgApp getAppContext() {
        return app;
    }

    public void add(Activity instance) {
        if (actStack == null)
            actStack = new Stack<Activity>();
        final int index = actStack.lastIndexOf(instance);
        if (index >= 0){
            actStack.remove(index);
        }
        actStack.add(instance);
    }

    public void remove(Activity instance){
        if (actStack == null)
            return;
        actStack.remove(instance);
    }

    /**
     * 获取主线程ID
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 获取主线程
     */
    public static Thread getMainThread() {
        return mMainThread;
    }

    /**
     * 获取主线程的handler
     */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    /**
     * 获取主线程的looper
     */
    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }
}
