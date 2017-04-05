package net.canway.cw.news.controller.adapter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.NewsBeanInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsHeadAdapter extends PagerAdapter {

    @InjectView(R.id.pager_iv)
    ImageView mPagerIv;
    @InjectView(R.id.pager_tv)
    TextView mPagerTv;
    private List<NewsBeanInfo.TopStoriesEntity> mTopStoriesEntities;
    private List<String> images;
    private List<String> titles;

    public NewsHeadAdapter(List<NewsBeanInfo.TopStoriesEntity> data) {
        this.mTopStoriesEntities = data;
        images = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i <data.size() ; i++) {
            images.add(data.get(i).getImage());
            titles.add(data.get(i).getTitle());
        }
    }


    @Override
    public int getCount() {
        return mTopStoriesEntities.size() > 0 ?Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //position = Integer.MAX_VALUE%position;
        position = position%mTopStoriesEntities.size();
        View view = View.inflate(UIUtils.getContext(), R.layout.news_head_viewpager, null);
        ButterKnife.inject(this,view);
        //设置控件中的内容
        Picasso.with(UIUtils.getContext()).load(images.get(position)).into(mPagerIv);
        //设置标题的内容
        mPagerTv.setText(titles.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
