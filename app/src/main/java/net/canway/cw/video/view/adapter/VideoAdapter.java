package net.canway.cw.video.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.base.MyBaseAdapter;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.video.model.bean.VideoBeanInfo;
import net.canway.cw.video.view.holder.VideoHolder;

import java.util.List;

import butterknife.InjectView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class VideoAdapter extends MyBaseAdapter<VideoBeanInfo.V9lg4b3a0> {

    @InjectView(R.id.video_head_iv)
    ImageView mVideoHeadIv;
    @InjectView(R.id.video_title_tv)
    TextView mVideoTitleTv;


    private List<VideoBeanInfo.V9lg4b3a0> mDatas;
    public VideoAdapter(List<VideoBeanInfo.V9lg4b3a0> datas) {
        super(datas);
        this.mDatas = datas;
    }

    @Override
    protected View getItemView(int i, View view, ViewGroup viewGroup) {
        VideoHolder mHolder = null;
        if(mHolder==null) {
            mHolder = new VideoHolder(UIUtils.getContext());
        }else{
            mHolder = (VideoHolder) view.getTag();
        }
        mHolder.setDataAndRefreshView(mDatas.get(i));
        return mHolder.mHolderView;
    }
}
