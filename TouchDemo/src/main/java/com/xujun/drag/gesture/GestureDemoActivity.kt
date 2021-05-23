package com.xujun.drag.gesture

import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import com.xujun.drag.R

class GestureDemoActivity : AppCompatActivity() {

    companion object {
        private val TAG = "GestureDemoActivity"
    }

    private lateinit var mDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture_demo)
        mDetector = GestureDetectorCompat(this, MyGestureListener())
        mDetector.setOnDoubleTapListener(object : GestureDetector.OnDoubleTapListener {
            override fun onDoubleTap(e: MotionEvent?): Boolean {
                Log.d(TAG, "onDoubleTap: e is e")
                return false
            }

            override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
                Log.d(TAG, "onDoubleTapEvent: e is e")
                return false
            }

            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                Log.d(TAG, "onSingleTapConfirmed: e is e")
                return false
            }

        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
//        return if (mDetector.onTouchEvent(event)){
//            true
//        } else {
//            super.onTouchEvent(event)
//        }
        mDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    private class MyGestureListener : GestureDetector.OnGestureListener {

        private val TAG = "GestureDemoActivity"

        override fun onShowPress(e: MotionEvent?) {
            Log.d(TAG, "onShowPress: e is $e")
        }


        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            Log.d(TAG, "onSingleTapUp: e is $e")
            return false
        }

        override fun onDown(event: MotionEvent): Boolean {
            Log.d(TAG, "onDown: $event")
            return true
        }

        override fun onFling(
                event1: MotionEvent,
                event2: MotionEvent,
                velocityX: Float,
                velocityY: Float
        ): Boolean {
            Log.d(TAG, "onFling: $event1 $event2")
            return false
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            Log.d(TAG, "onScroll: distanceX is $distanceX,distanceY is $distanceY ")
            return false
        }

        override fun onLongPress(e: MotionEvent?) {
            Log.d(TAG, "onLongPress: e is $e")
        }
    }

    private class MySimpleGestureListener : GestureDetector.SimpleOnGestureListener() {

        private val TAG = "GestureDemoActivity"

        override fun onShowPress(e: MotionEvent?) {
            Log.d(TAG, "onShowPress: e is $e")

        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            Log.d(TAG, "onSingleTapConfirmed: e is $e")
            return super.onSingleTapConfirmed(e)
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            Log.d(TAG, "onDoubleTap: e is $e")
            return super.onDoubleTap(e)
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            Log.d(TAG, "onDoubleTapEvent: e is $e")
            return super.onDoubleTapEvent(e)
        }


        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            Log.d(TAG, "onSingleTapUp: e is $e")
            return false
        }

        override fun onDown(event: MotionEvent): Boolean {
            Log.d(TAG, "onDown: $event")
            return false
        }

        override fun onFling(
                event1: MotionEvent,
                event2: MotionEvent,
                velocityX: Float,
                velocityY: Float
        ): Boolean {
            Log.d(TAG, "onFling: $event1 $event2")
            return false
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            Log.d(TAG, "onScroll: distanceX is $distanceX,distanceY is $distanceY ")
            return false
        }

        override fun onLongPress(e: MotionEvent?) {
            Log.d(TAG, "onLongPress: e is $e")
        }
    }
}