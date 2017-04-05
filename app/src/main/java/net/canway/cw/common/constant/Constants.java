package net.canway.cw.common.constant;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class Constants {
    public static final int DEBUGLEVEL = 0;
    /**
     * debug调试模式，所以只在debug模式下使用的功能使用该变量进行判断
     */
    public static final boolean DEBUG = true;
    public static  final String BASE_URL = "http://news-at.zhihu.com/api/4";
    public static  final String VIDEO_URL = "http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html";

    // 登录模块常量
    public static final int LOGING_SUCCESS = 0;
    public static final int LOGING_INPUT_ERROR = 1;
    public static final int LOGING_INPUT_EMPTY = 2;
    public static final int LOGING_NOREGISTER= 3;

    // 注册模块常量
    public static final int REG_SUCCESS = 4;
    public static final int REG_ALREADY_REGISTER = 5;
    public static final int REG_PWD_NOTEQU = 6;
    public static final int REG_INPUT_EMPTY = 7;
    public static final int REG_FAIL = 8;

}
