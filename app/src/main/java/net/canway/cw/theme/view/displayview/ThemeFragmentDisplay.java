package net.canway.cw.theme.view.displayview;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

import net.canway.cw.common.factory.ListViewFactory;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;
import net.canway.cw.theme.controller.adapter.ThemesAdapter;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemeFragmentDisplay {
    @NonNull
    public View getViewByData(List<ThemeBeanInfo.OthersEntity> mOthers) {
        ListView listView = ListViewFactory.creatListView(UIUtils.getContext());
        listView.setAdapter(new ThemesAdapter(mOthers));
        return listView;
    }
}
