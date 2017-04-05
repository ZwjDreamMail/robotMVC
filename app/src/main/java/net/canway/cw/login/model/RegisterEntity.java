package net.canway.cw.login.model;

import net.canway.cw.common.constant.Constants;
import net.canway.cw.common.util.Md5Utils;
import net.canway.cw.datastore.dao.UserDao;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class RegisterEntity {
    int id;
    String username;
    String pwd;
    String confirmPwd;

    public RegisterEntity() {
    }

    public RegisterEntity(int id, String username, String pwd, String confirmPwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public int register(){

        if("".equals(username)&&"".equals(pwd)&&"".equals(confirmPwd)) {
            return Constants.REG_INPUT_EMPTY;
        }
        //判断用户名是否被注册
        UserDao dao = new UserDao();
        List<RegisterEntity> loginUsers = dao.queryRegister(username);
        if(loginUsers.size()>0) {
            return Constants.REG_ALREADY_REGISTER;
        }
        //密码是否一致的判断
        if(!confirmPwd.equals(pwd)) {
            return Constants.REG_PWD_NOTEQU;
        }
        String md5 = Md5Utils.getMd5(pwd);
        boolean b = dao.addUser(username, md5);

        if(b) {
            return Constants.REG_SUCCESS;
        }else{
            return Constants.REG_FAIL;
        }
    }


}
