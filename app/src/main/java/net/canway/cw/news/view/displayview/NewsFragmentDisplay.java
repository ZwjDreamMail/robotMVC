package net.canway.cw.news.view.displayview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.canway.cw.common.factory.ListViewFactory;
import net.canway.cw.common.util.IntentUtils;
import net.canway.cw.common.util.SharePreferenceUtil;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.controller.activity.WebViewActivity;
import net.canway.cw.news.model.bean.NewsBeanInfo;
import net.canway.cw.news.controller.adapter.NewsAdapter;
import net.canway.cw.news.view.holder.NewsHeadHolder;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsFragmentDisplay {

    @NonNull
    public View getViewByData(final Activity activity,
                              List<NewsBeanInfo.TopStoriesEntity> top_stories,
                              final List<NewsBeanInfo.StoriesEntity> stories
                               ) {
        //创建一个listview
        ListView listView = ListViewFactory.creatListView(UIUtils.getContext());
        NewsHeadHolder mHolder = new NewsHeadHolder(UIUtils.getContext());
        mHolder.setDataAndRefreshView(top_stories);
        listView.addHeaderView(mHolder.mHolderView);
        listView.setAdapter(new NewsAdapter(stories));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharePreferenceUtil.saveString(UIUtils.getContext(),"ID",stories.get(i-1).getId()+"");
                IntentUtils.statrtIntent(activity, WebViewActivity.class);
            }
        });
        return listView;
    }
}
