package net.canway.cw.login.controller.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseActivity;
import net.canway.cw.common.constant.Constants;
import net.canway.cw.common.util.IntentUtils;
import net.canway.cw.common.util.ToastUtils;
import net.canway.cw.login.model.LoginEntity;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class LoginActivity extends BaseActivity {
    @InjectView(R.id.user)
    EditText mUser;
    @InjectView(R.id.password)
    EditText mPassword;
    @InjectView(R.id.login)
    Button mLogin;
    @InjectView(R.id.register)
    Button mRegister;

    @Override
    protected void initClickListener() {
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.statrtIntent(LoginActivity.this,RegisterActivity.class);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = mUser.getText().toString();
                String pwd = mPassword.getText().toString();
                // 将逻辑处理和数据存储交给model层去处理
                LoginEntity loginEntity = new LoginEntity(0,username,pwd);
                int loginstate = loginEntity.login();
                switch (loginstate) {
                    case  Constants.LOGING_INPUT_EMPTY:
                        ToastUtils.showTaost(LoginActivity.this,"用户名或者密码为空");
                        break;
                    case  Constants.LOGING_INPUT_ERROR:
                        ToastUtils.showTaost(LoginActivity.this,"输入密码不正确");
                        break;
                    case  Constants.LOGING_NOREGISTER:
                        ToastUtils.showTaost(LoginActivity.this,"用户没有注册");
                        break;
                    case  Constants.LOGING_SUCCESS:
                        IntentUtils.statrtIntentAndFinish(LoginActivity.this,MainActivity.class);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        setContentView(R.layout.login_activity);
        ButterKnife.inject(this);
    }

    @Override
    protected void releaceSource() {

    }

}
