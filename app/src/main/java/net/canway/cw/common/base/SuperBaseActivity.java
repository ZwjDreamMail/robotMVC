package net.canway.cw.common.base;

import android.view.View;

import net.canway.cw.common.util.UIUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public abstract  class SuperBaseActivity extends BaseActivity {
    private BaseUiDisplay mUiDisplay;

    @Override
    protected void initClickListener() {

    }

    @Override
    protected void initView() {
        if(mUiDisplay==null) {
            mUiDisplay = new BaseUiDisplay(UIUtils.getContext()) {
                @Override
                protected View initSuccessView() {
                    return SuperBaseActivity.this.initSuccessView();
                }

                @Override
                protected LoadingDataState initData() {
                    return SuperBaseActivity.this.initData();
                }
            };
        }
        setContentView(mUiDisplay);
    }

    /**
     * 外界要求通过BaseUidispaly加载数据的时候被调用
     * @return
     */
    protected abstract BaseUiDisplay.LoadingDataState initData();

    /**
     * 在加载数据成功的时候调用显示视图
     * @return
     */
    protected abstract View initSuccessView();

    @Override
    protected void releaceSource() {

    }

    /**
     *
     * @param o 传入的数据
     * @return  返回加载的状态
     */
    public BaseUiDisplay.LoadingDataState checkData(Object o){
        if(o==null) {
            return BaseUiDisplay.LoadingDataState.EMPTY;
        }

        if(o instanceof List) {
            if(((List) o).size()==0) {
                return BaseUiDisplay.LoadingDataState.EMPTY;
            }else {
                return BaseUiDisplay.LoadingDataState.SUCCESS;
            }
        }

        if(o instanceof Map) {
            if(((Map) o).size()==0) {
                return BaseUiDisplay.LoadingDataState.EMPTY;
            }else {
                return BaseUiDisplay.LoadingDataState.SUCCESS;
            }
        }
        //加载数据的状态是成功,也就是数据不为空
        return BaseUiDisplay.LoadingDataState.SUCCESS;
    }
}
