package com.github.a1607869392.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2

class Vp2NestedFrameLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null):
    FrameLayout(context, attrs){
    private  val  parentViewPager2: ViewPager2?
        get() {
            var view: View?=parent as? View
            while (view!=null &&view !is ViewPager2){
                view=view.parent as? View
            }
            return view as? ViewPager2
        }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE->{
                parentViewPager2?.isUserInputEnabled=false

            }else ->{
            parentViewPager2?.isUserInputEnabled=true
        }
        }
        return super.dispatchTouchEvent(ev)
    }

}