package net.canway.cw.datastore.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.canway.cw.common.util.UIUtils;
import net.canway.cw.datastore.db.UserDataHelper;
import net.canway.cw.login.model.LoginEntity;
import net.canway.cw.login.model.RegisterEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class UserDao{
    private UserDataHelper mHelper;
    private  static  final String TABLE_NAME = "user";
    public UserDao(){
        mHelper = new UserDataHelper(UIUtils.getContext());
    }

    /**
     * 添加用户名到数据库
     * @param username 用户名
     * @param pwd 用户密码
     * @return
     */
    public boolean addUser(String username ,String pwd){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        //封装数据
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("pwd",pwd);
        //进行数据库插入操作
        long insert = db.insert(TABLE_NAME, null, values);
        if(insert>0) {
            return true;
        }
        return false;
    }

    public List<LoginEntity> queryByName(String username){
        List<LoginEntity> mLoginEntities = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"_id","username", "pwd"}, "username=?",
                new String[]{username}, null, null, null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String pwd = cursor.getString(2);
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setUsername(name);
            loginEntity.setPwd(pwd);
            mLoginEntities.add(loginEntity);
        }
        db.close();
        cursor.close();
        return mLoginEntities;
    }

    public List<RegisterEntity> queryRegister(String username){
        List<RegisterEntity> mRegisterEntities = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"_id","username", "pwd"}, "username=?",
                new String[]{username}, null, null, null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String pwd = cursor.getString(2);
            RegisterEntity registerEntity = new RegisterEntity();
            registerEntity.setUsername(name);
            registerEntity.setPwd(pwd);
            mRegisterEntities.add(registerEntity);
        }
        db.close();
        cursor.close();
        return mRegisterEntities;
    }
}
