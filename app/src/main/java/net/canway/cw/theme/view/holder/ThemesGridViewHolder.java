package net.canway.cw.theme.view.holder;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;

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
public class ThemesGridViewHolder extends BaseHolder<ThemeBeanInfo.OthersEntity> {


    @InjectView(R.id.theme_grid_iv)
    ImageView mThemeGridIv;

    public ThemesGridViewHolder(Context context) {
        super(context);
    }

    @Override
    protected void refreshViewByData(ThemeBeanInfo.OthersEntity data) {
        //设置图片
        Picasso.with(UIUtils.getContext()).load(data.getThumbnail()).into(mThemeGridIv);
    }

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.theme_gridview_item, null);
        ButterKnife.inject(this, view);
        return view;
    }
}
