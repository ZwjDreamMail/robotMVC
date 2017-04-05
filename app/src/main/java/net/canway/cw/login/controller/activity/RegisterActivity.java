package net.canway.cw.login.controller.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseActivity;
import net.canway.cw.common.constant.Constants;
import net.canway.cw.common.util.IntentUtils;
import net.canway.cw.common.util.ToastUtils;
import net.canway.cw.login.model.RegisterEntity;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class RegisterActivity extends BaseActivity {

    @InjectView(R.id.user)
    EditText mUser;
    @InjectView(R.id.password)
    EditText mPassword;
    @InjectView(R.id.confirm)
    EditText mConfirm;
    @InjectView(R.id.register)
    Button mRegister;

    @Override
    protected void initClickListener() {
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户输入的信息
                String username = mUser.getText().toString();
                //获取密码
                String pwd = mPassword.getText().toString();
                //获取第二次输入的密码
                String cpwd = mConfirm.getText().toString();
                RegisterEntity entity = new RegisterEntity(0,username,pwd,cpwd);
                int register = entity.register();
                switch (register) {
                    case Constants.REG_INPUT_EMPTY :
                        ToastUtils.showTaost(RegisterActivity.this,"输入信息不为空");
                        break;
                    case Constants.REG_ALREADY_REGISTER :
                        ToastUtils.showTaost(RegisterActivity.this,"用户已经被注册");
                        break;
                    case Constants.REG_PWD_NOTEQU :
                        ToastUtils.showTaost(RegisterActivity.this,"两次输入密码不一致");
                        break;
                    case Constants.REG_SUCCESS :
                        ToastUtils.showTaost(RegisterActivity.this,"注册成功");
                        IntentUtils.statrtIntentAndFinish(RegisterActivity.this,LoginActivity.class);
                        break;
                    case Constants.REG_FAIL:
                        ToastUtils.showTaost(RegisterActivity.this,"注冊失敗");
                        break;
                }

            }
        });
    }

    @Override
    protected void initView() {
        setContentView(R.layout.login_register_activity);
        ButterKnife.inject(this);


    }

    @Override
    protected void releaceSource() {

    }

}
