package com.xujun.drag.multiclick

import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

/**
 * Created by jun xu on 5/17/21.
 */
open class MyMultiTouchListener(private val myClickCallBack: MyClickCallBack) : OnTouchListener {

    private var clickCount = 0 //记录连续点击次数
    private val handler: Handler = Handler()

    interface MyClickCallBack {
        fun oneClick() //点击一次的回调
        fun doubleClick() //连续点击两次的回调
        fun threeClick()
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            clickCount++
            handler.postDelayed({
                if (clickCount == 1) {
                    myClickCallBack.oneClick()
                } else if (clickCount == 2) {
                    myClickCallBack.doubleClick()
                } else if (clickCount == 3) {
                    myClickCallBack.threeClick()
                }
                handler.removeCallbacksAndMessages(null)
                //清空handler延时，并防内存泄漏
                clickCount = 0 //计数清零
            }, timeout.toLong()) //延时timeout后执行run方法中的代码
        }
        return false //让点击事件继续传播，方便再给View添加其他事件监听
    }

    companion object {
        private const val TAG = "MyClickListener"
        private val timeout = 600 //双击间四百毫秒延时

        init {
            Log.i(TAG, "timeout is $timeout ")
        }
    }
}