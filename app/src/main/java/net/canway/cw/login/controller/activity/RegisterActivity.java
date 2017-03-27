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

                if("".equals(username)&&"".equals(pwd)&&"".equals(cpwd)) {
                    ToastUtils.showTaost(RegisterActivity.this,"输入信息不为空");
                    return;
                }
                //判断用户名是否被注册
                UserDao dao = new UserDao();
                List<User> users = dao.queryByName(username);
                if(users.size()>0) {
                    ToastUtils.showTaost(RegisterActivity.this,"用户已经被注册");
                    return;
                }

                //密码是否一致的判断
                if(!cpwd.equals(pwd)) {
                    ToastUtils.showTaost(RegisterActivity.this,"两次输入密码不一致");
                    return;
                }
                String md5 = Md5Utils.getMd5(pwd);
                boolean b = dao.addUser(username, md5);
                if(b) {
                    ToastUtils.showTaost(RegisterActivity.this,"注册成功");
                    IntentUtils.statrtIntentAndFinish(RegisterActivity.this,LoginActivity.class);
                }else{
                    ToastUtils.showTaost(RegisterActivity.this,"注冊失敗");
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
