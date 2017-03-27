package net.canway.cw.common.factory;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ListViewFactory {
    public static ListView creatListView(Context context){
        ListView lv = new ListView(context);
        //常规的设置
        lv.setSelector(new ColorDrawable(Color.TRANSPARENT));
        lv.setFastScrollEnabled(true);
        lv.setDividerHeight(0);
        lv.setCacheColorHint(Color.TRANSPARENT);
        lv.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return lv;
    }
}
