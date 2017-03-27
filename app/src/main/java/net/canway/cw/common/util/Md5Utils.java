package net.canway.cw.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 张文建
 * @time 2016/7/26  10:33
 * @desc ${TODD}
 */
public class Md5Utils {

    public static String getMd5(String text) {
        MessageDigest digest = null;
        try {
            //SHA
            digest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] reslut = digest.digest(text.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : reslut) {
            String str = Integer.toHexString(b & 0xff);
            if (str.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(str);
        }
        
        return stringBuffer.toString();
    }
}
