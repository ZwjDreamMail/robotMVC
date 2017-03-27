package net.canway.cw.news.view.holder;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseHolder;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.NewsBeanInfo;
import net.canway.cw.news.view.adapter.NewsHeadAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsHeadHolder extends BaseHolder<List<NewsBeanInfo.TopStoriesEntity>> {


    @InjectView(R.id.head_pager)
    ViewPager mHeadPager;
    @InjectView(R.id.head_container_indicator)
    LinearLayout mHeadContainerIndicator;

    public NewsHeadHolder(Context context) {
        super(context);
    }

    @Override
    protected void refreshViewByData(List<NewsBeanInfo.TopStoriesEntity> data) {
        mHeadPager.setAdapter(new NewsHeadAdapter(data));
        mHeadContainerIndicator.removeAllViews();
        for (int i = 0; i <data.size() ; i++) {
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setPadding(10,10,10,10);
            if(i==0) {
                iv.setImageResource(R.drawable.news_indicator_selected);
            }else{
                iv.setImageResource(R.drawable.news_indicator_normal);
            }
            mHeadContainerIndicator.addView(iv);
        }

        mHeadPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 当前哪一张图片显示在viewpager上面
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                position = position%mHeadContainerIndicator.getChildCount();
                int childCount = mHeadContainerIndicator.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ImageView imageView = (ImageView) mHeadContainerIndicator.getChildAt(i);
                    if(i==position) {
                        imageView.setImageResource(R.drawable.news_indicator_selected);
                    }else{
                        imageView.setImageResource(R.drawable.news_indicator_normal);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.news_head_viewpager_item, null);
        ButterKnife.inject(this,view);
        return view;
    }
}
