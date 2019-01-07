package com.xujun.drag.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by jun xu on 19-1-7.
 */
public class ScrollLinearLayoutManager extends LinearLayoutManager {

    private boolean isScrollEnable = true;

    public ScrollLinearLayoutManager(Context context) {
        super(context);
    }

    public ScrollLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public ScrollLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnable && super.canScrollVertically();
    }

    /**
     * Set whether the RecyclerView can slide vertically
     *
     * @param isEnable
     */
    public void setScrollVerticallyEnable(boolean isEnable) {
        this.isScrollEnable = isEnable;
    }

}
