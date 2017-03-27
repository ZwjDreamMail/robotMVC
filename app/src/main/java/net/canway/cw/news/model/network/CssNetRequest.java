package net.canway.cw.news.model.network;


import net.canway.cw.common.base.BaseNetRequest;
import net.canway.cw.common.util.SharePreferenceUtil;
import net.canway.cw.common.util.UIUtils;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class CssNetRequest extends BaseNetRequest<String> {
    @Override
    protected String getURLString() {
        String cssUrl = SharePreferenceUtil.getString(UIUtils.getContext(), "CSS");
        return cssUrl;
    }
}
