package net.canway.cw.theme.view.holder;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseHolder;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemesHolder extends BaseHolder<ThemeBeanInfo.OthersEntity> {

    @InjectView(R.id.news_iv)
    ImageView mNewsIv;
    @InjectView(R.id.news_tv)
    TextView mNewsTv;
    @InjectView(R.id.news_topic)
    TextView mNewsTopic;
    @InjectView(R.id.cardview)
    CardView mCardview;

    public ThemesHolder(Context context) {
        super(context);
    }

    @Override
    protected void refreshViewByData(ThemeBeanInfo.OthersEntity data) {
        //设置图片
        Picasso.with(UIUtils.getContext()).load(data.getThumbnail()).into(mNewsIv);
        //设置描述文字
        mNewsTv.setText(data.getDescription());
        //设置信息来源
        mNewsTopic.setText(data.getName());
    }

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.theme_cardview_item, null);
        ButterKnife.inject(this,view);
        return view;
    }
}
