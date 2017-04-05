package net.canway.cw.common.util;

import android.content.Context;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;

import net.canway.cw.app.AppApplication;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class UIUtils {

    public static Context getContext(){
        return AppApplication.getmContext();
    }

    public static Handler getHandler(){
        return AppApplication.getmHandler();
    }

    /**
     * 安全的执行一个任务的方法
     * @param task  任务
     */
    public static  void postTaskSafey(Runnable task){
        long currentThreadId = android.os.Process.myTid();
        long mainThreadId = AppApplication.getMainThread();
        if(currentThreadId==mainThreadId) {
           task.run();
        }else{
            Handler handler = getHandler();
            handler.post(task);
        }
    }

    /**
     * dp-->px
     */
    public static int dp2Px(int dp){
        float density = getContext().getResources().getDisplayMetrics().density;
        int px = (int) (dp*density+.5f);
        return px;
    }

    /**
     * px-->dip
     * @param px
     * @return
     */
    public static int px2Dip(int px) {

        float density = getContext().getResources().getDisplayMetrics().density;//1.5
        int dp = (int) (px / density + .5f);
        return dp;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public static int getScreenHeight(){
        WindowManager manager = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }

    /**
     * 获取屏幕的宽度
     * @return
     */
    public static int getScreenWidth(){
        WindowManager manager = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }


}
