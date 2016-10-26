package com.xujun.drag.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xujun.drag.ItemAdapter;
import com.xujun.drag.R;
import com.xujun.drag.base.BaseFragment;
import com.xujun.drag.base.BaseFragmentAdapter;
import com.xujun.drag.base.RecyclerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/25 23:27
 * @ email：gdutxiaoxu@163.com
 */
public class ListFragment extends BaseFragment {

    private Context mContext;
    private View mView;
    static final String key = "key";

    ViewPager mViewPager;
    TextView mTextView;

    RecyclerView mRecyclerView;
    private List<Fragment> mFragments;
    private BaseFragmentAdapter mBaseAdapter;
    private ArrayList<String> mList;
    private ItemAdapter mItemAdapter;

    ScrollView mNoHorizontalScrollView;
    private boolean first = true;
    boolean isViewInited = false;
    boolean isDataInited = false;
    private int mSize = 4;;
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
        isViewInited = true;
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mTextView = (TextView) view.findViewById(R.id.tv_page);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mNoHorizontalScrollView = (ScrollView) view.findViewById(R.id.NoHorizontalScrollView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void fetchData() {


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(mIsVisibleToUser==false  && isViewInitiated && isDataInited){
            mScrollY = mNoHorizontalScrollView.getScrollY();
            mScrollX = mNoHorizontalScrollView.getScrollX();

        }else if(mIsVisibleToUser==true && isViewInitiated && isDataInited){
            mNoHorizontalScrollView.scrollTo(mScrollX,mScrollY);
        }
    }


    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();

    }

    private void scroll() {
        mNoHorizontalScrollView.scrollTo(0, 0);
    }

    @Override
    protected void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mTextView.setText(String.format("%d/"+mSize, position + 1));
            }
        });



    }

    @Override
    protected void initData() {
        mTextView.setText(String.format("%d/"+mSize, 1));
        isDataInited = true;
        Bundle arguments = getArguments();
        String title = "";
        if (arguments != null) {
            title = arguments.getString(key);
        }
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String s = String.format("我是第%d个测试Item" + title, i);
            mList.add(s);
        }
        mItemAdapter = new ItemAdapter(getActivity(), mList);
        RecyclerUtils.init(mRecyclerView);
        mRecyclerView.setAdapter(mItemAdapter);

        mFragments = new ArrayList<>();

        for (int i = 0; i < mSize; i++) {
            ImageFragment imageFragment = ImageFragment.newInstance(R.drawable.huoying);
            mFragments.add(imageFragment);
        }

        mBaseAdapter = new BaseFragmentAdapter(getChildFragmentManager()
                , mFragments);
        mViewPager.setAdapter(mBaseAdapter);

        mViewPager.setFocusable(true);
        mViewPager.setFocusableInTouchMode(true);
        mViewPager.requestFocus();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }
}
