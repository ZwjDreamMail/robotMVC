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
public class LoginEntity {
    String username;
    String pwd;


    public LoginEntity() {
    }

    public LoginEntity(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
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

    public int login(){
        //进行一个非空判断
        if("".equals(username)||"".equals(pwd)) {
            return Constants.LOGING_INPUT_EMPTY;
        }

        //判断用户是否已经注册
        UserDao dao = new UserDao();
        List<LoginEntity> loginEntities = dao.queryByName(username);
        if(loginEntities.size()<=0) {
            return Constants.LOGING_NOREGISTER;
        }

        String pwd1 = loginEntities.get(0).getPwd();
        String cpwd = Md5Utils.getMd5(pwd);
        if(cpwd.equals(pwd1)) {
            return Constants.LOGING_SUCCESS;
        }else{
            return Constants.LOGING_INPUT_ERROR;
        }

    }


}
