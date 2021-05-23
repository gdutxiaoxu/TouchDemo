package com.xujun.drag.multiclick

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.xujun.drag.R
import kotlinx.android.synthetic.main.activity_multi_click.*

class MultiClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_click)
        val myClickCallBack = object : MyDoubleTouchListener.MyClickCallBack {
            override fun oneClick() {
                Toast.makeText(this@MultiClickActivity, "单击", Toast.LENGTH_SHORT).show()
            }

            override fun doubleClick() {
                Toast.makeText(this@MultiClickActivity, "双击", Toast.LENGTH_SHORT).show()
            }

        }
        btn_1.setOnTouchListener(object : MyDoubleTouchListener(myClickCallBack) {
        })

        val myMultiCallBack = object : MyMultiTouchListener.MyClickCallBack {
            override fun oneClick() {
                Toast.makeText(this@MultiClickActivity, "单击", Toast.LENGTH_SHORT).show()
            }

            override fun doubleClick() {
                Toast.makeText(this@MultiClickActivity, "双击", Toast.LENGTH_SHORT).show()
            }

            override fun threeClick() {
                Toast.makeText(this@MultiClickActivity, "三击", Toast.LENGTH_SHORT).show()
            }

        }
        btn_2.setOnTouchListener(object : MyMultiTouchListener(myMultiCallBack) {

        })
    }
}