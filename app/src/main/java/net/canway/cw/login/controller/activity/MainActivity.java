package net.canway.cw.login.controller.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.news.controller.fragment.NewsFragment;
import net.canway.cw.theme.controller.fragment.ThemesFragment;
import net.canway.cw.video.controller.fragment.MediaFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class MainActivity extends FragmentActivity {

    FrameLayout mTabContent;
    FragmentTabHost mTabs;

    @InjectView(R.id.icon)
    ImageView mIcon;
    @InjectView(R.id.title)
    TextView mTitle;

    private String[] titles;
    private Class[] f_class;
    private int[] selector;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main_activity);
        mTabs = (FragmentTabHost) findViewById(R.id.tabs);
        mTabContent = (FrameLayout) findViewById(R.id.tabContent);

        mTabs.setBackgroundColor(Color.parseColor("#01ff0000"));
        // mTabs.getBackground().setAlpha(0);

        //获取标题
        titles = getResources().getStringArray(R.array.tabhost_title);
        //设置对应的fragment数组
        f_class = new Class[]{NewsFragment.class, ThemesFragment.class, MediaFragment.class};
        //引入选择的时候背景变化的视图数组
        selector = new int[]{R.drawable.news_tab_selector, R.drawable.theme_tab_selector, R.drawable.video_tab_selector};
        mTabs.setup(UIUtils.getContext(), getSupportFragmentManager(), R.id.tabContent);

        for (int i = 0; i < titles.length; i++) {
            View view = View.inflate(UIUtils.getContext(), R.layout.app_item_tab, null);
            ButterKnife.inject(this,view);
            mIcon.setBackground(getResources().getDrawable(selector[i]));
            mTitle.setText(titles[i]);

            TabHost.TabSpec host = mTabs.newTabSpec(i+"");
            host.setIndicator(view);
            //将底部菜单栏和fragment进行一个绑定
            mTabs.addTab(host,f_class[i],null);
        }

        mTabs.getTabWidget().setBackgroundColor(Color.TRANSPARENT);
    }
}
