package net.canway.cw.news.controller.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.canway.cw.common.base.BaseFragment;
import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.common.factory.ListViewFactory;
import net.canway.cw.common.util.IntentUtils;
import net.canway.cw.common.util.SharePreferenceUtil;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.controller.activity.WebViewActivity;
import net.canway.cw.news.model.bean.NewsBeanInfo;
import net.canway.cw.news.model.network.NewsDataRequest;
import net.canway.cw.news.view.adapter.NewsAdapter;
import net.canway.cw.news.view.holder.NewsHeadHolder;

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
        //创建一个listview
        ListView listView = ListViewFactory.creatListView(UIUtils.getContext());
        NewsHeadHolder mHolder = new NewsHeadHolder(UIUtils.getContext());
        mHolder.setDataAndRefreshView(mTop_stories);
        listView.addHeaderView(mHolder.mHolderView);
        listView.setAdapter(new NewsAdapter(mStories));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharePreferenceUtil.saveString(UIUtils.getContext(),"ID",mStories.get(i).getId()+"");
                IntentUtils.statrtIntent(getActivity(), WebViewActivity.class);
            }
        });
        return listView;
    }
}
