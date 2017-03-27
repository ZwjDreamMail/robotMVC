package net.canway.cw.theme.view.adapter;


import android.view.View;
import android.view.ViewGroup;

import net.canway.cw.common.base.MyBaseAdapter;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;
import net.canway.cw.theme.view.holder.ThemesHolder;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemesAdapter extends MyBaseAdapter<ThemeBeanInfo.OthersEntity> {

    public ThemesAdapter(List<ThemeBeanInfo.OthersEntity> datas) {
        super(datas);
    }

    @Override
    protected View getItemView(int i, View view, ViewGroup viewGroup) {
        ThemesHolder themesHolder=null;
        if(themesHolder==null) {
            themesHolder = new ThemesHolder(UIUtils.getContext());
        }else{
            themesHolder = (ThemesHolder) view.getTag();
        }
        themesHolder.setDataAndRefreshView(mDatas.get(i));
        return themesHolder.mHolderView;
    }
}
