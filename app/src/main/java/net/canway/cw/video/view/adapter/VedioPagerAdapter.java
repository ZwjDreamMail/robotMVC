package net.canway.cw.video.view.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.canway.cw.common.util.UIUtils;
import net.canway.cw.video.model.FragmentInfo;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class VedioPagerAdapter extends FragmentPagerAdapter {

    private List<FragmentInfo> mFragmentInfos;
    public VedioPagerAdapter(FragmentManager fm, List<FragmentInfo> fragmentInfos) {
        super(fm);
        mFragmentInfos = fragmentInfos;
    }

    @Override
    public Fragment getItem(int position) {
        FragmentInfo info = mFragmentInfos.get(position);
        Class aClass = info.getaClass();
        return Fragment.instantiate(UIUtils.getContext(),aClass.getName());
    }

    @Override
    public int getCount() {
        return mFragmentInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        FragmentInfo info = mFragmentInfos.get(position);
        return info.getTitle();
    }

    @Override
    public int getItemPosition(Object object) {
        return (int) object;
    }

}
