package net.canway.cw.video.view.displayview;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.video.controller.fragment.VidioFragment;
import net.canway.cw.video.model.FragmentInfo;
import net.canway.cw.video.view.adapter.VedioPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class MediaFragmentDisplay {
    @InjectView(R.id.videocontroller1)
    fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard mVideocontroller1;
    @InjectView(R.id.viewpagerTab)
    SmartTabLayout mViewpagerTab;
    @InjectView(R.id.viewPager)
    ViewPager mViewPager;
    private String[] mTitles;
    private List<FragmentInfo> mfragmentInfo;


    public View getViewByData(Activity activity, FragmentManager manager) {
        View view = View.inflate(UIUtils.getContext(), R.layout.vedio_fragment, null);
        ButterKnife.inject(this, view);
        mfragmentInfo = new ArrayList<>();
        mVideocontroller1.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
                "Android开发",
                "一行代码实现视频播放");
        //获取titles
        mTitles = activity.getResources().getStringArray(R.array.smart_title);
        for (int i = 0; i <mTitles.length ; i++) {
            FragmentInfo minfo = new FragmentInfo(mTitles[i],VidioFragment.class);
            mfragmentInfo.add(minfo);
        }
        mViewPager.setAdapter(new VedioPagerAdapter(manager,mfragmentInfo));
        //一定要给smartlayout设置对应视图
        mViewpagerTab.setViewPager(mViewPager);
        return view;
    }

}
