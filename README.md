Vp2NestedFrameLayout 是一个用于解决 ViewPager2 与嵌套滑动 View（如 RecyclerView、ScrollView、HorizontalScrollView 等）之间滑动冲突 的自定义 FrameLayout。只需将可能产生滑动冲突的视图用此布局包裹，即可避免 ViewPager2 的滑动被误触发，实现更加顺畅的嵌套滑动体验。
