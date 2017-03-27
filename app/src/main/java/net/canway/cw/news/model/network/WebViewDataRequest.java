package net.canway.cw.news.model.network;


import net.canway.cw.common.base.BaseNetRequest;
import net.canway.cw.common.constant.Constants;
import net.canway.cw.common.util.SharePreferenceUtil;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.HtmlBeanInfo;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class WebViewDataRequest extends BaseNetRequest<HtmlBeanInfo> {
    @Override
    protected String getURLString() {
        String id = SharePreferenceUtil.getString(UIUtils.getContext(), "ID");
        return Constants.BASE_URL+"/story/"+id;
    }
}
