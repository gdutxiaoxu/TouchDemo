package com.xujun.drag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/25 09:12
 * @ email：gdutxiaoxu@163.com
 */
public class BaseViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments = new ArrayList<>();

    String[] mtitles;

    public BaseViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        this(fm, fragments, null);
    }

    public BaseViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] mtitles) {
        super(fm);
        this.mFragments = fragments;
        this.mtitles = mtitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles[position];
    }
}
