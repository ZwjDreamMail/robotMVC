package net.canway.cw.theme.controller.adapter;

import android.view.View;
import android.view.ViewGroup;

import net.canway.cw.common.base.MyBaseAdapter;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;
import net.canway.cw.theme.view.holder.ThemesGridViewHolder;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class GridViewAdapter extends MyBaseAdapter<ThemeBeanInfo.OthersEntity> {

    public GridViewAdapter(List<ThemeBeanInfo.OthersEntity> datas) {
        super(datas);
    }

    @Override
    protected View getItemView(int i, View view, ViewGroup viewGroup) {
        ThemesGridViewHolder themesHolder=null;
        if(themesHolder==null) {
            themesHolder = new ThemesGridViewHolder(UIUtils.getContext());
        }else{
            themesHolder = (ThemesGridViewHolder) view.getTag();
        }
        themesHolder.setDataAndRefreshView(mDatas.get(i));
        return themesHolder.mHolderView;
    }
}
