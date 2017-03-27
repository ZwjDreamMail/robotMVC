package net.canway.cw.news.controller.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseUiDisplay;
import net.canway.cw.common.base.SuperBaseActivity;
import net.canway.cw.common.util.SharePreferenceUtil;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.HtmlBeanInfo;
import net.canway.cw.news.model.network.CssNetRequest;
import net.canway.cw.news.model.network.WebViewDataRequest;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.picasso.Picasso;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class WebViewActivity extends SuperBaseActivity {

    @InjectView(R.id.web)
    WebView mWeb;
    @InjectView(R.id.web_iv)
    ImageView mWebIv;
    @InjectView(R.id.web_tv)
    TextView mWebTv;
    @InjectView(R.id.head_rl)
    RelativeLayout mHeadRl;

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

        View view = View.inflate(UIUtils.getContext(), R.layout.news_webview_fragment, null);
        ButterKnife.inject(this,view);
        Picasso.with(UIUtils.getContext()).load(mHtmlBeanInfo.getImage()).into(mWebIv);
        mWebTv.setText(mHtmlBeanInfo.getTitle());
        //打开支持js的开关
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //获取html数据
        mHtml = "<html>\n" +
                "\t<head>" + "<style type=\"text/css\">" + mCss
                + "</style><script type=\"text/javascript\">"
                + mHtmlBeanInfo.getJs() + "</script></head>" + mHtmlBeanInfo.getBody().toString() + "</html>";
        mWeb.loadDataWithBaseURL(null,mHtml,"text/html","utf-8",null);
        mHeadRl.measure(0,0);
        final int height = mHeadRl.getMeasuredHeight();

        mWeb.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                mHeadRl.setVisibility(View.VISIBLE);
                float f = 1-(float)i1/(float)height;
                if(height>i1) {
                    mHeadRl.setAlpha(f);
                    mHeadRl.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,height-i1));
                }else{
                    mHeadRl.setVisibility(View.INVISIBLE);
                }

            }
        });
        return view;
    }
}
