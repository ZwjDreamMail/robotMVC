package net.canway.cw.common.base;

import android.content.Context;
import android.view.View;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public abstract class BaseHolder<DATATYPE> {
    public  View mHolderView;
    private DATATYPE mDatas;
    private Context mContext;

    public BaseHolder(Context context){
        //获取上下文路径
        this.mContext = context;
        //获取视图
        mHolderView = initHolderView();
        mHolderView.setTag(this);
    }

    public void setDataAndRefreshView(DATATYPE data){
        mDatas = data;
        refreshViewByData(data);
    }

    /**
     * 外界要求数据绑定并显示视图的时候被调用
     * @param data
     */
    protected abstract void refreshViewByData(DATATYPE data);

    /**
     * 初识化视图,引入界面需要的一些部件,以及相关控件id的查找
     * @return  listview需要显示的视图
     */

    protected abstract View initHolderView();


}
