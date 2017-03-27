package net.canway.cw.common.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public abstract class MyBaseAdapter<BEANTYPE> extends BaseAdapter {
    public List<BEANTYPE> mDatas = new ArrayList<>();

    public MyBaseAdapter(List<BEANTYPE> datas){
        this.mDatas = datas;
    }
    @Override
    public int getCount() {
        return mDatas.size()>0?mDatas.size():0;
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 返回最终显示的listview条目的视图
     * @param i  当前是listview中的第几个视图
     * @param view  对应的item的视图
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemView(i,view,viewGroup);
    }

    /**
     * listview具体视图的获取方法
     * @param i  数据的id
     * @param view  具体视图的view
     * @param viewGroup
     * @return
     */
    protected abstract View getItemView(int i, View view, ViewGroup viewGroup);
}
