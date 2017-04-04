package net.canway.cw.video.controller.fragment;


import android.view.View;

import net.canway.cw.common.base.BaseFragment;
import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.video.model.bean.VideoBeanInfo;
import net.canway.cw.video.model.network.VideoRequest;
import net.canway.cw.video.view.displayview.MediaFragmentDisplay;

import java.io.IOException;

import butterknife.ButterKnife;
/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */

/*mVideocontroller1.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
        "Android开发",
        "一行代码实现视频播放");*/

public class MediaFragment extends BaseFragment {

    private VideoRequest mVideoRequest;
    private VideoBeanInfo mVideoBeanInfo;

    @Override
    public void onPause() {
        super.onPause();
        //JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @Override
    protected BaseUiDisplay.LoadingDataState initData() {
        mVideoRequest = new VideoRequest();
        try {
            mVideoBeanInfo = mVideoRequest.loadData(true);
            BaseUiDisplay.LoadingDataState state = checkData(mVideoBeanInfo);
            if (state != BaseUiDisplay.LoadingDataState.SUCCESS) {
                return state;
            }
            return state;
        } catch (IOException e) {
            e.printStackTrace();
            return BaseUiDisplay.LoadingDataState.ERROR;
        }

    }

    @Override
    protected View initSuccessView() {
        return new MediaFragmentDisplay().getViewByData(getContext(),getFragmentManager(),mVideoBeanInfo);
    }

}
