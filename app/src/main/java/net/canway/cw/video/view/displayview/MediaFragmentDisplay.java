package net.canway.cw.video.view.displayview;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.video.model.bean.VideoBeanInfo;
import net.canway.cw.video.view.adapter.VideoAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class MediaFragmentDisplay {


    @InjectView(R.id.videocontroller)
    JCVideoPlayerStandard mVideocontroller;
    @InjectView(R.id.video_lv)
    ListView mVideoLv;
    private List<VideoBeanInfo.V9lg4b3a0> mV9lg4b3a0;

    public View getViewByData(Context context, FragmentManager manager, final VideoBeanInfo videoBeanInfo) {
        View view = View.inflate(UIUtils.getContext(), R.layout.vedio_fragment, null);
        ButterKnife.inject(this, view);
        // 获取对应的视频数据
        mV9lg4b3a0 = videoBeanInfo.getV9lg4b3a0();
        VideoAdapter adapter = new VideoAdapter(videoBeanInfo.getV9lg4b3a0());
        mVideoLv.setAdapter(adapter);

        mVideocontroller.setUp(mV9lg4b3a0.get(1).getMp4_url(),
                mV9lg4b3a0.get(1).getTitle(),
                "一行代码实现视频播放");
        mVideoLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mVideocontroller.setUp(mV9lg4b3a0.get(i).getMp4_url(),
                        mV9lg4b3a0.get(i).getTitle(),
                        "一行代码实现视频播放");
                // 设置点击直接播放视频
                view.setId(R.id.start);
                mVideocontroller.onClick(view);
            }
        });
        return view;
    }

}
