package net.canway.cw.news.view.holder;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseHolder;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.NewsBeanInfo;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsHolder extends BaseHolder<NewsBeanInfo.StoriesEntity> {

    @InjectView(R.id.news_iv)
    ImageView mNewsIv;
    @InjectView(R.id.news_tv)
    TextView mNewsTv;
    @InjectView(R.id.cardview)
    CardView mCardview;

    public NewsHolder(Context context) {
        super(context);
    }

    @Override
    protected void refreshViewByData(NewsBeanInfo.StoriesEntity data) {
        mNewsTv.setText(data.getTitle());
        Picasso.with(UIUtils.getContext()).load(data.getImages().get(0)).into(mNewsIv);
    }

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.news_cardview_item, null);
        ButterKnife.inject(this,view);
        return view;
    }
}
