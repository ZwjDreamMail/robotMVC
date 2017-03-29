package net.canway.cw.news.controller.activity;


import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.common.base.SuperBaseActivity;
import net.canway.cw.common.util.SharePreferenceUtil;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.HtmlBeanInfo;
import net.canway.cw.news.model.network.CssNetRequest;
import net.canway.cw.news.model.network.WebViewDataRequest;
import net.canway.cw.news.view.displayview.WebViewDisplay;

import java.io.IOException;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class WebViewActivity extends SuperBaseActivity {


    private WebViewDataRequest mDataRequest;
    private CssNetRequest mCssNetRequest;
    private String mCss;
    private String mHtml;

    private HtmlBeanInfo mHtmlBeanInfo;

    @Override
    protected BaseUiDisplay.LoadingDataState initData() {
        mDataRequest = new WebViewDataRequest();
        try {
            mHtmlBeanInfo = mDataRequest.loadData(true);
            BaseUiDisplay.LoadingDataState state = checkData(mHtmlBeanInfo);
            if (state != BaseUiDisplay.LoadingDataState.SUCCESS) {
                return state;
            }

            String cssUrl = mHtmlBeanInfo.getCss().get(0);
            SharePreferenceUtil.saveString(UIUtils.getContext(), "CSS", cssUrl);
            if (cssUrl != null) {
                mCssNetRequest = new CssNetRequest();
            }
            mCss = mCssNetRequest.loadData(false);
            return state;
        } catch (IOException e) {
            e.printStackTrace();
            return BaseUiDisplay.LoadingDataState.ERROR;
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected View initSuccessView() {
        return  new WebViewDisplay().getWebViewByData(this,mCss,mHtmlBeanInfo);
    }

}

