package net.canway.cw.common.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;
import java.util.Map;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
// //使用eclipse的同学因为v4包版本的问题,需要加上这段代码
/*ViewParent parent = mLoadingPager.getParent();
        if (parent != null && parent instanceof ViewGroup) {
        ((ViewGroup) parent).removeView(mLoadingPager);
        }*/


public abstract  class BaseFragment extends Fragment {

    private  BaseUiDisplay mUiDisplay;
    private TwinklingRefreshLayout mRefreshLayout;
    private View mSuccessView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mUiDisplay==null) {
            mUiDisplay = new BaseUiDisplay(getContext()) {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                protected View initSuccessView() {
                    removeAllViews();
                    // mRefreshLayout = new TwinklingRefreshLayout(getContext());
                    mSuccessView = BaseFragment.this.initSuccessView();
                    /*mRefreshLayout.addView(mSuccessView);
                    ProgressLayout layout = new ProgressLayout(getContext());
                    mRefreshLayout.setHeaderHeight(180);
                    mRefreshLayout.setWaveHeight(140);
                    mRefreshLayout.setHeaderView(layout);
                    mRefreshLayout.setScrollBarFadeDuration(1000);

                    mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
                        @Override
                        public void onFinishLoadMore() {
                            mRefreshLayout.finishLoadmore();
                        }

                        @Override
                        public void onFinishRefresh() {
                            //进行网络数据的请求
                            mRefreshLayout.finishRefreshing();
                        }
                    });*/

                    return mSuccessView;
                }

                @Override
                protected LoadingDataState initData() {
                    return BaseFragment.this.initData();
                }
            };
        }

        return mUiDisplay;
    }

    /**
     * 在子类中触发加载数据的时候调用
     * 基类无法知道具体的实现,所以子类必须去实现
     * @return 加载数据的状态
     */
    protected abstract BaseUiDisplay.LoadingDataState initData();

    /**
     * 子类在加载视图的时候调用
     * 基类无法知道具体的实现,所以子类必须去实现
     * @return   加载成功的视图
     */
    protected abstract View initSuccessView();

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
