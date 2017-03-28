package net.canway.cw.theme.controller.fragment;


import android.view.View;

import net.canway.cw.common.base.BaseFragment;
import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;
import net.canway.cw.theme.Model.network.ThemesDataRequest;
import net.canway.cw.theme.view.displayview.ThemeFragmentDisplay;

import java.io.IOException;
import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemesFragment extends BaseFragment {

    private ThemesDataRequest mDataRequest;
    private ThemeBeanInfo mThemeBeanInfo;
    private List<ThemeBeanInfo.OthersEntity> mOthers;

    @Override
    protected BaseUiDisplay.LoadingDataState initData() {
        mDataRequest = new ThemesDataRequest();
        try {
            mThemeBeanInfo = mDataRequest.loadData(true);
            BaseUiDisplay.LoadingDataState state = checkData(mThemeBeanInfo);
            if (state != BaseUiDisplay.LoadingDataState.SUCCESS) {
                return state;
            }
            mOthers = mThemeBeanInfo.getOthers();
            state = checkData(mOthers);
            if (state != BaseUiDisplay.LoadingDataState.SUCCESS) {
                return state;
            }
            return state;
        } catch (IOException e) {
            e.printStackTrace();
            return BaseUiDisplay.LoadingDataState.ERROR;
        }
    }

    @Override
    protected View initSuccessView() {
        return new ThemeFragmentDisplay().getViewByData(mOthers);
    }


}
