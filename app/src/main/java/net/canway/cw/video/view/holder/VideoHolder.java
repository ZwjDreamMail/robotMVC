package net.canway.cw.video.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseHolder;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.video.model.bean.VideoBeanInfo;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class VideoHolder extends BaseHolder<VideoBeanInfo.V9lg4b3a0> {

    @InjectView(R.id.video_head_iv)
    ImageView mVideoHeadIv;
    @InjectView(R.id.video_title_tv)
    TextView mVideoTitleTv;

    public VideoHolder(Context context) {
        super(context);
    }

    @Override
    protected void refreshViewByData(VideoBeanInfo.V9lg4b3a0 data) {
        String topicImg = data.getTopicImg();
        String title = data.getTitle();
        Picasso.with(UIUtils.getContext()).load(topicImg).into(mVideoHeadIv);
        mVideoTitleTv.setText(title);
    }

    @Override
    protected View initHolderView() {
        View videoView = View.inflate(UIUtils.getContext(), R.layout.video_list_item, null);
        ButterKnife.inject(this, videoView);
        return videoView;
    }
}
