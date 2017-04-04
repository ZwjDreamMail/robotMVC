package net.canway.cw.video.model.network;

import net.canway.cw.common.base.BaseNetRequest;
import net.canway.cw.common.constant.Constants;
import net.canway.cw.video.model.bean.VideoBeanInfo;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class VideoRequest extends BaseNetRequest<VideoBeanInfo>{
    @Override
    protected String getURLString() {
        return Constants.VIDEO_URL;
    }
}
