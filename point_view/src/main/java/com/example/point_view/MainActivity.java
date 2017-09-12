package com.example.point_view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indicatepointview.PointView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List pageData;
    private ViewPager viewPager;
    private PointView pv;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vp);
        initData();
        pv = (PointView) findViewById(R.id.pv);
        pv.setPointNum(pageData.size());
        pv.setCurrentColor("#888888");
        pv.setPointColor("#46528a");
        adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        initListener();
    }

    /**
     * 初始化数据
     */
    public void initData(){
        pageData = new ArrayList();
        for (int i = 0;i<5;i++){
            pageData.add(i);
        }
    }

    /**
     * 初始化监听事件
     */
    public void initListener(){
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,"这里是"+(position+1),Toast.LENGTH_SHORT).show();
                pv.setCurrentPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    private class ViewPagerAdapter extends PagerAdapter{
        private TextView textView;

        @Override
        public int getCount() {
            return pageData.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(MainActivity.this,R.layout.layout,null);
            textView = (TextView) view.findViewById(R.id.tv);
            textView.setText("这是第"+(position+1)+"页");
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
