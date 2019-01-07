package com.xujun.drag.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xujun.drag.R;
import com.xujun.drag.base.BaseFragment;
import com.xujun.drag.base.BaseFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.xujun.drag.R.id.NoHorizontalScrollView;

/**
 * @ explain:
 * @ author：xujun on 2016/10/25 23:27
 * @ email：gdutxiaoxu@163.com
 */
public class ListFragment extends BaseFragment {

    static final String key = "key";
    public static final String TAG = "xujun";

    private String mTitle = "";

    ViewPager mViewPager;
    TextView mTextView;

    private List<Fragment> mFragments;
    private BaseFragmentAdapter mBaseAdapter;

    ScrollView mNoHorizontalScrollView;

    private int mSize = 4;

    private int mScrollY;
    private int mScrollX;

    public static ListFragment newInstance(String title) {
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(key, title);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    @Override
    protected void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mTextView = (TextView) view.findViewById(R.id.tv_page);
        mNoHorizontalScrollView = (ScrollView) view.findViewById(NoHorizontalScrollView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void fetchData() {
        Log.i(TAG, "fetchData: mTitle =" + mTitle);
        int scrollY = mNoHorizontalScrollView.getScrollY();
    }

    /**
     * 在界面切换的时候会调用这个方法
     * true 表示可见
     * FALSE 表示不可见
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, "setUserVisibleHint: mTitle=" + mTitle + "  " + " isVisibleToUser=" +
                isVisibleToUser);
        if (isVisibleToUser) {//表示界面可见
            if (mNoHorizontalScrollView != null) {// 之所以判断是否为空，
                Log.i(TAG, "setUserVisibleHint: mTitle=" + mTitle + "  " + " isVisibleToUser=" +
                        isVisibleToUser + "mScrollY=" + mScrollY);
                //                mNoHorizontalScrollView.setDescendantFocusability(ViewGroup
                // .FOCUS_BLOCK_DESCENDANTS);
            }

        } else {// 表示界面不可见
            if (mNoHorizontalScrollView != null) {
                mScrollX = mNoHorizontalScrollView.getScrollX();
                mScrollY = mNoHorizontalScrollView.getScrollY();
                Log.i(TAG, "setUserVisibleHint: mTitle=" + mTitle + "  " + " isVisibleToUser=" +
                        isVisibleToUser + "mScrollY=" + mScrollY);
            }
        }
    }

    @Override
    protected void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mTextView.setText(String.format("%d/" + mSize, position + 1));
            }
        });
    }

    @Override
    protected void initData() {
        mTextView.setText(String.format("%d/" + mSize, 1));
        Bundle arguments = getArguments();
        String title = "";
        if (arguments != null) {
            title = arguments.getString(key);
            mTitle = title;
        }
        
        mFragments = new ArrayList<>();

        for (int i = 0; i < mSize; i++) {
            ImageFragment imageFragment = ImageFragment.newInstance(R.drawable.huoying);
            mFragments.add(imageFragment);
        }

        mBaseAdapter = new BaseFragmentAdapter(getChildFragmentManager()
                , mFragments);
        mViewPager.setAdapter(mBaseAdapter);
        //     是为了确保mNoHorizontalScrollView他的子孙不能获得焦点
        mNoHorizontalScrollView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

      /*  mViewPager.setFocusable(true);
        mViewPager.setFocusableInTouchMode(true);
        mViewPager.requestFocus();*/
    }

    public void onSelected() {

    }

}
