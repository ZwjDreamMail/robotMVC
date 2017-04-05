package net.canway.cw.news.controller.adapter;


import android.view.View;
import android.view.ViewGroup;

import net.canway.cw.common.base.MyBaseAdapter;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.NewsBeanInfo;
import net.canway.cw.news.view.holder.NewsHolder;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsAdapter extends MyBaseAdapter<NewsBeanInfo.StoriesEntity> {

    private List<NewsBeanInfo.StoriesEntity> mStoriesEntities;
    public NewsAdapter(List<NewsBeanInfo.StoriesEntity> datas) {
        super(datas);
        mStoriesEntities = datas;
    }

    @Override
    protected View getItemView(int i, View view, ViewGroup viewGroup) {
        NewsHolder mHolder = null;
        if(mHolder==null) {
            mHolder = new NewsHolder(UIUtils.getContext());
        }else{
            mHolder = (NewsHolder) view.getTag();
        }
        mHolder.setDataAndRefreshView(mStoriesEntities.get(i));
        return mHolder.mHolderView;
    }
}
