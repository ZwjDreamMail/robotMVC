package net.canway.cw.common.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initClickListener();
    }

    //只是被那些已经创建过并且将persistableMode设置为persistAcrossReboots的activtiy调用
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    /**
     * 初识化监听器
     */
    protected abstract void initClickListener();

    /**
     * 初始化界面显示的视图
     */
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaceSource();
    }

    /**
     * 释放资源
     */
    protected abstract void releaceSource();
}
