package net.canway.cw.theme.view.holder;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.base.BaseHolder;
import net.canway.cw.common.util.UIUtils;
import net.canway.cw.theme.Model.bean.ThemeBeanInfo;
import net.canway.cw.theme.controller.adapter.GridViewAdapter;
import net.canway.cw.theme.view.custom.ThemeGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemesHolder extends BaseHolder<ThemeBeanInfo.OthersEntity> {


    @InjectView(R.id.friend_header)
    ImageView mFriendHeader;
    @InjectView(R.id.friend_name)
    TextView mFriendName;
    @InjectView(R.id.friend_tv_time)
    TextView mFriendTvTime;
    @InjectView(R.id.friend_topic)
    TextView mFriendTopic;
    @InjectView(R.id.friend_grid)
    ThemeGridView mFriendGrid;
    @InjectView(R.id.rl4)
    RelativeLayout mRl4;
    @InjectView(R.id.rl_info)
    RelativeLayout mRlInfo;

    public ThemesHolder(Context context) {
        super(context);
    }

    @Override
    protected void refreshViewByData(ThemeBeanInfo.OthersEntity data) {
        List<ThemeBeanInfo.OthersEntity> datas = new ArrayList<>();
        for (int i = 0; i < (data.getId()/2); i++) {
            datas.add(data);
        }

        mRl4.setVisibility(View.VISIBLE);
        switch (datas.size()%3) {
            case 1 :
                if(datas.size()>1) {
                    mFriendGrid.setNumColumns(3);
                }else{
                    mFriendGrid.setNumColumns(1);
                }
                break;
            case 2 :
                if(datas.size()>2) {
                    mFriendGrid.setNumColumns(3);
                }else{
                    mFriendGrid.setNumColumns(2);
                }
                break;
            case 3 :
                mFriendGrid.setNumColumns(3);
                break;

        }

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(UIUtils.getScreenWidth() - UIUtils.dp2Px(50), UIUtils.getScreenWidth() - UIUtils.dp2Px(50));
        mFriendGrid.setLayoutParams(lp);

        GridViewAdapter adapter = new GridViewAdapter(datas);
        mFriendGrid.setAdapter(adapter);

        //设置描述文字
        mFriendTopic.setText(data.getDescription());
        //设置信息来源
        mFriendName.setText(data.getName());
    }

    @Override
    protected View initHolderView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.theme_cardview_item, null);
        ButterKnife.inject(this, view);
        return view;
    }
}
