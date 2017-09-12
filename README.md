# PointView2 #

PointView2是用来为布局添加指示点的控件。使用方便，可用于android中Fragment和ViewPager在实现循环播放，或者滚动时添加指示点。

## 特点 ##


1. 使用简单，不需要额外布局，引入后，在布局中只需要给定控件大小和位置即可
2. 在代码中，只需要在初始化过程中指定点的个数和颜色。


## 布局示例 ##
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:tools="http://schemas.android.com/tools" android:id="@+id/activity_main"
	android:layout_width="match_parent" android:layout_height="match_parent"
	android:paddingBottom="@dimen/activity_vertical_margin"
	android:paddingLeft="@dimen/activity_horizontal_margin"
	android:paddingRight="@dimen/activity_horizontal_margin"
	android:paddingTop="@dimen/activity_vertical_margin"
	tools:context="com.example.point_view.MainActivity">
	<android.support.v4.view.ViewPager
	    android:id="@+id/vp"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    >
	</android.support.v4.view.ViewPager>
	<com.example.indicatepointview.PointView
	    android:id="@+id/pv"
	    android:layout_width="match_parent"
	    android:layout_height="20dp"
	    android:layout_alignParentBottom="true"
	    />
	</RelativeLayout>
这是一个简单的布局示例。

## 引用规则 ##
1. 首先在工程gradle中引入：maven { url 'https://jitpack.io' }，如：
	 ![](https://i.imgur.com/2RyViNS.png)
 
2. 在项目的gradle中添加依赖： 
	`compile 'com.github.JAtank:PointView2:v0.02'`

## 示例 ##
示例地址为[https://github.com/JAtank/PointView2.git](https://github.com/JAtank/PointView2.git)，
项目中的point_view即为简单示例。