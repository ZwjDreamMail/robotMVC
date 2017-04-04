package net.canway.cw.news.view.displayview;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.model.bean.HtmlBeanInfo;
import net.canway.cw.news.view.custom.ScrollWebView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class WebViewDisplay {


    @InjectView(R.id.web)
    ScrollWebView mWeb;
    @InjectView(R.id.web_iv)
    ImageView mWebIv;
    @InjectView(R.id.web_tv)
    TextView mWebTv;
    @InjectView(R.id.head_rl)
    RelativeLayout mHeadRl;

    private String mHtml;
    @TargetApi(Build.VERSION_CODES.M)
    public View getWebViewByData(String css, HtmlBeanInfo htmlBeanInfo) {
        View view = View.inflate(UIUtils.getContext(), R.layout.news_webview_fragment, null);
        ButterKnife.inject(this,view);

        Log.e("canway", htmlBeanInfo.getImage());

        Picasso.with(UIUtils.getContext()).load(htmlBeanInfo.getImage()).into(mWebIv);
        mWebTv.setText(htmlBeanInfo.getTitle());

        //打开支持js的开关
        mWeb.getSettings().setJavaScriptEnabled(true);

        mWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //获取html数据
        mHtml = "<html>\n" +
                "\t<head>" + "<style type=\"text/css\">" + css
                + "</style><script type=\"text/javascript\">"
                + htmlBeanInfo.getJs() + "</script></head>" + htmlBeanInfo.getBody().toString() + "</html>";
        mWeb.loadDataWithBaseURL(null, mHtml, "text/html", "utf-8", null);
        mHeadRl.measure(0, 0);
        final int height = mHeadRl.getMeasuredHeight();

        // 可以获取到网页的标题
        mWeb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });

        mWeb.setOnScrollChangeListener(new ScrollWebView.OnScrollChangeListener() {
            @Override
            public void onPageEnd(int l, int t, int oldl, int oldt) {

            }

            @Override
            public void onPageTop(int l, int t, int oldl, int oldt) {

            }

            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                mHeadRl.setVisibility(View.VISIBLE);
                float f = 1 - (float) t / (float) height;
                if (height > t) {
                    mHeadRl.setAlpha(f);
                    mHeadRl.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, height - t));
                } else {
                    mHeadRl.setVisibility(View.INVISIBLE);
                }
            }
        });
        return view;
    }
}
