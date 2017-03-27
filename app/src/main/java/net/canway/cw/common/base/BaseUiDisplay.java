package net.canway.cw.common.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import net.canway.cw.R;
import net.canway.cw.common.factory.ThreadPoolPoxyFactory;
import net.canway.cw.common.util.UIUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public abstract class BaseUiDisplay<T> extends FrameLayout {
    private View mLodingView;
    private View mErrorView;
    private View mEmptyView;
    private View mSuccessView;
    private String mStringUrl;


    private static final int LOAING = 0;
    private static final int LOAING_ERROR = 1;
    private static final int LOAING_EMPTY = 2;
    private static final int LOAING_SUCCESS = 3;

    private int mCurrentState = LOAING;
    private LoadingDataTask mTask;

    public BaseUiDisplay(Context context) {
        super(context);
        initCommonView();
    }

    private void initCommonView() {
        //加载页面
        mLodingView = View.inflate(UIUtils.getContext(), R.layout.app_pager_loading, null);
        this.addView(mLodingView);
        //加载数据错误的时候显示的页面
        mErrorView = View.inflate(UIUtils.getContext(), R.layout.app_pager_error, null);
        this.addView(mErrorView);
        mErrorView.findViewById(R.id.error_btn_retry).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                triggeLoadingData();
            }
        });
        //加载的数据为空时显示 的页面
        mEmptyView = View.inflate(UIUtils.getContext(), R.layout.app_pager_empty, null);
        this.addView(mEmptyView);
        //调用触发加载数据
        triggeLoadingData();
    }

    /**
     * 触发加载数据
     */
    public void triggeLoadingData() {
        //进行数据的加载


        if (mCurrentState != LOAING_SUCCESS && mTask == null) {
            mCurrentState = LOAING;
            refreshByState();
            mTask = new LoadingDataTask();
            //执行数据加载的任务
            ThreadPoolPoxyFactory.creatThreadPoxy().ExecutorTask(mTask);
        }
    }

    /**
     * 用来执行加载数据的任务
     */

    class LoadingDataTask implements Runnable {
        @Override
        public void run() {
            LoadingDataState state = initData();
            mCurrentState = state.getState();
            UIUtils.postTaskSafey(new Runnable() {
                @Override
                public void run() {
                    refreshByState();
                }
            });
        }
    }


    public void refreshByState() {
        //加载的时候就显示加载视图
        mLodingView.setVisibility((mCurrentState == LOAING) ? VISIBLE : INVISIBLE);
        //加载错误的时候显示错误视图
        mErrorView.setVisibility((mCurrentState == LOAING_ERROR) ? VISIBLE : INVISIBLE);
        //加载数据为空的时候显示空视图
        mEmptyView.setVisibility((mCurrentState == LOAING_EMPTY) ? VISIBLE : INVISIBLE);
        if (mCurrentState == LOAING_SUCCESS && mSuccessView == null) {
            mSuccessView = initSuccessView();
            this.addView(mSuccessView);
        }
    }

    public enum LoadingDataState {
        SUCCESS(LOAING_SUCCESS), ERROR(LOAING_ERROR), EMPTY(LOAING_EMPTY);
        int state;

        LoadingDataState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }

    /**
     * @param o 传入的数据
     * @return 返回加载的状态
     */
    public BaseUiDisplay.LoadingDataState checkData(T o) {
        if (o == null) {
            return BaseUiDisplay.LoadingDataState.EMPTY;
        }

        if (o instanceof List) {
            if (((List) o).size() == 0) {
                return BaseUiDisplay.LoadingDataState.EMPTY;
            } else {
                return BaseUiDisplay.LoadingDataState.SUCCESS;
            }
        }

        if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return BaseUiDisplay.LoadingDataState.EMPTY;
            } else {
                return BaseUiDisplay.LoadingDataState.SUCCESS;
            }
        }
        //加载数据的状态是成功,也就是数据不为空
        return BaseUiDisplay.LoadingDataState.SUCCESS;
    }

    /**
     * 视图加载成功的时候调用
     * 父类无法知道加工成功视图的具体实现,所以交给子类去实现
     *
     * @return 加载成功的视图
     */
    protected abstract View initSuccessView();

    protected abstract LoadingDataState initData();
}
