package net.canway.cw.news.model.network;


import net.canway.cw.common.base.BaseNetRequest;
import net.canway.cw.common.constant.Constants;
import net.canway.cw.news.model.bean.NewsBeanInfo;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsDataRequest extends BaseNetRequest<NewsBeanInfo> {
    @Override
    protected String getURLString() {
        return Constants.BASE_URL+"/stories/latest";
    }
}
