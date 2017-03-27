package net.canway.cw.login.controller.activity;

import android.os.Handler;
import android.os.Message;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseActivity;
import net.canway.cw.common.util.IntentUtils;
import net.canway.cw.common.util.ToastUtils;
import net.canway.cw.login.view.CicleLodingImageVIew;
import net.canway.cw.login.view.IloadingClick;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class SplashActivity extends BaseActivity {

    CicleLodingImageVIew loadingview;
    int degree = 0;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            degree += 30;
            //设置对应的一个度数给自定义控件
            loadingview.setCurrentDegree(degree);
            if (degree >= 360) {
                IntentUtils.statrtIntentAndFinish(SplashActivity.this, LoginActivity.class);
                mHandler.removeCallbacks(resh);
            }
        }
    };

    @Override
    protected void initClickListener() {
        loadingview.setClick(new IloadingClick() {
            @Override
            public void onClick(CicleLodingImageVIew lodingImageVIew) {
                ToastUtils.showTaost(SplashActivity.this, "点击事件");
                IntentUtils.statrtIntentAndFinish(SplashActivity.this, LoginActivity.class);
                mHandler.removeCallbacks(resh);

            }
        });
    }

    @Override
    protected void initView() {
        setContentView(R.layout.login_in_activity);
        loadingview = (CicleLodingImageVIew) findViewById(R.id.loading_view);
        mHandler.post(resh);

    }


    @Override
    protected void releaceSource() {

    }

    Runnable resh = new Runnable() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            //延迟1秒
            mHandler.postDelayed(resh, 1000);
        }
    };

}

