package net.canway.cw.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class AppApplication extends Application {
    private static Context mContext;
    private  static Handler mHandler;
    private static long mMainThreadId;

    public static Context getmContext(){
        return mContext;
    }
    public static Handler getmHandler(){
        return mHandler;
    }
    public static Long getMainThread(){
        return mMainThreadId;
    }

    @Override
    public void onCreate() {

        //上下文路径
        mContext = getApplicationContext();
        //全局handler
        mHandler = new Handler();
        //获取主线程id
        mMainThreadId = android.os.Process.myTid();

        super.onCreate();
    }
}
