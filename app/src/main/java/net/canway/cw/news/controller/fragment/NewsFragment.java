package net.canway.cw.news.controller.fragment;

import android.view.View;

import net.canway.cw.common.base.BaseFragment;
import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.news.model.bean.NewsBeanInfo;
import net.canway.cw.news.model.network.NewsDataRequest;
import net.canway.cw.news.view.displayview.NewsFragmentDisplay;

import java.io.IOException;
import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsFragment extends BaseFragment {

    private NewsDataRequest mDataRequest;
    private List<NewsBeanInfo.TopStoriesEntity> mTop_stories;
    private List<NewsBeanInfo.StoriesEntity> mStories;

    @Override
    protected BaseUiDisplay.LoadingDataState initData() {

        if(mDataRequest == null) {
            mDataRequest = new NewsDataRequest();

            //加载网络数据
            try {
                NewsBeanInfo newsBeanInfo = mDataRequest.loadData(true);
                BaseUiDisplay.LoadingDataState state = checkData(newsBeanInfo);
                if(state!= BaseUiDisplay.LoadingDataState.SUCCESS) {
                    return state;
                }
                //获取顶部轮播信息的对象
                mTop_stories = newsBeanInfo.getTop_stories();
                state = checkData(mTop_stories);
                if(state!= BaseUiDisplay.LoadingDataState.SUCCESS) {
                    return state;
                }
                mStories = newsBeanInfo.getStories();
                return state;
            } catch (IOException e) {
                e.printStackTrace();
                return BaseUiDisplay.LoadingDataState.ERROR;
            }
        }
        return null;
    }

    @Override
    protected View initSuccessView() {
        return new NewsFragmentDisplay().getViewByData(getActivity(),mTop_stories,mStories);

    }


}
