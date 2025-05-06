Vp2NestedFrameLayout 是一个用于解决 ViewPager2 与嵌套滑动 View（如 RecyclerView、ScrollView、HorizontalScrollView 等）之间滑动冲突 的自定义 FrameLayout。只需将可能产生滑动冲突的视图用此布局包裹，即可避免 ViewPager2 的滑动被误触发，实现更加顺畅的嵌套滑动体验。

 <com.github.a1607869392.widget.Vp2NestedFrameLayout 
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <!-- 嵌套滑动的 RecyclerView、ScrollView 等 -->
    <androidx.recyclerview.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
          </com.github.a1607869392.widget.Vp2NestedFrameLayout>

原理说明
在 dispatchTouchEvent() 方法中，我们监听了当前触摸事件的类型：
ACTION_DOWN / ACTION_MOVE 时：表示当前用户正在滑动或即将滑动嵌套的子 View（如 RecyclerView、ScrollView 等），此时我们暂时禁用 ViewPager2 的滑动功能，即 parentViewPager2?.isUserInputEnabled = false，防止 ViewPager2 抢占滑动事件。
其他事件（如 ACTION_UP, ACTION_CANCEL）时：表示用户已结束触摸滑动，此时恢复 ViewPager2 的滑动能力。
通过这种方式，我们实现了 在子 View 滑动时临时禁止 ViewPager2 滑动 的机制，解决了滑动手势冲突问题。

