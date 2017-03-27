package net.canway.cw.theme.Model.network;


import net.canway.cw.common.base.BaseNetRequest;
import net.canway.cw.common.constant.Constants;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemesDataRequest extends BaseNetRequest<ThemeBeanInfo> {
    @Override
    protected String getURLString() {
        return Constants.BASE_URL+"/themes";
    }
}
