package net.canway.cw.common.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * @author 张文建
 * @time 2016/7/25  9:10
 * @desc 在子线程和主线程都能运行的toast
 */
public  class ToastUtils {

    public static void showTaost(final Activity context, final String text){
        //判断当前是否是被子线程调用
        if("main".equals(Thread.currentThread().getName())) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }else {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
