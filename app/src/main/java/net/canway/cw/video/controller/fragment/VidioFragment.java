package net.canway.cw.video.controller.fragment;


import android.view.View;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseFragment;
import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.common.util.UIUtils;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class VidioFragment extends BaseFragment {
    @Override
    protected BaseUiDisplay.LoadingDataState initData() {
        return BaseUiDisplay.LoadingDataState.SUCCESS;
    }

    @Override
    protected View initSuccessView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.vedio_smart_item, null);
        return view;
    }
}
