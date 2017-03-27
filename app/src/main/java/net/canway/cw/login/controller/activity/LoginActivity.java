package net.canway.cw.login.controller.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseActivity;
import net.canway.cw.common.util.IntentUtils;
import net.canway.cw.common.util.Md5Utils;
import net.canway.cw.common.util.ToastUtils;
import net.canway.cw.datastore.dao.UserDao;
import net.canway.cw.login.model.User;

import java.util.List;

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

                //进行一个非空判断
                if("".equals(username)||"".equals(pwd)) {
                    ToastUtils.showTaost(LoginActivity.this,"用户名或者密码为空");
                    return;
                }
                //判断用户是否已经注册
                UserDao dao = new UserDao();
                List<User> users = dao.queryByName(username);
                if(users.size()<=0) {
                    ToastUtils.showTaost(LoginActivity.this,"用户没有注册");
                    return;
                }

                String pwd1 = users.get(0).getPwd();
                String cpwd = Md5Utils.getMd5(pwd);
                
                if(cpwd.equals(pwd1)) {
                    IntentUtils.statrtIntentAndFinish(LoginActivity.this,MainActivity.class);
                }else{
                    ToastUtils.showTaost(LoginActivity.this,"输入密码不正确");
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
