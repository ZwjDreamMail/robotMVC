package net.canway.cw.login.controller.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseActivity;
import net.canway.cw.login.view.custom.SplashCustomView;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class SplashActivity extends BaseActivity {

    @InjectView(R.id.splash_custom_news)
    SplashCustomView mSplashCustomNews;
    @InjectView(R.id.splash_custom_friend)
    SplashCustomView mSplashCustomFriend;
    @InjectView(R.id.splash_custom_video)
    SplashCustomView mSplashCustomVideo;
    @InjectView(R.id.splash_experience)
    Button mSplashExperience;
    @InjectView(R.id.splash_login)
    Button mSplashLogin;

    @Override
    protected void initClickListener() {
        // 立即体验,进入到主界面
        mSplashExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 进入到登录界面进行登录操作
        mSplashLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        setContentView(R.layout.login_in_activity);
        ButterKnife.inject(this);
    }

    @Override
    protected void releaceSource() {

    }

}

