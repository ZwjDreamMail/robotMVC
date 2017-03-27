package net.canway.cw.common.util;

import android.app.Activity;
import android.content.Intent;

/**
 * @author 张文建
 * @time 2016/7/23  11:06
 * @desc页面跳转的工具方法
 */
public class IntentUtils {

    /**
     *
     * @param context activity
     * @param clazz  字节码
     * @param delayTime 开启一个qctivity需要延迟
     */
    public static void startIntentAndDelteyAndFinish(final Activity context, final Class clazz, final long delayTime){
        new Thread(){
            public void run(){
                try {
                    sleep(delayTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(context,clazz);
                context.startActivity(intent);
                context.finish();

            }
        }.start();

    }


    public  static void  statrtIntentAndFinish(Activity context, final Class clazz){
        Intent intent=new Intent(context,clazz);
        context.startActivity(intent);
        //关闭当前页面
        context.finish();
    }

    public  static void  statrtIntent(Activity context, final Class clazz){
        Intent intent=new Intent(context,clazz);
        context.startActivity(intent);

    }
}
