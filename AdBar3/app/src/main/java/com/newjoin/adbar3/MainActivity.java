package com.newjoin.adbar3;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by NewJoin on 2019-1-20 15:20:18.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager vpAd;
    private int[] arrAdImg=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpAd=findViewById(R.id.vpAd);
        //给 viewPager 设置数据
        vpAd.setAdapter(new MyAdapter());

        //实现可以无限左滑
        vpAd.setCurrentItem(arrAdImg.length*10000);
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            //实现无限滑动
            return Integer.MAX_VALUE;
        }

        //判断当前展示的 view 和返回的 object 是否是同一个对象，如果是，才展示
        @Override
        public boolean isViewFromObject(View view, Object object) {
            //return false;

            return view==object;
        }

        //初始化每个 item 布局，默认加载 前一张和 后一张
        //当张树大于2张时，始终保持3张
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //return super.instantiateItem(container, position);

            //0，1，2，3，4
            //5，6，7，8，9
            int pos=position%arrAdImg.length;

            Log.d(TAG,"初始化item-----"+pos);

            ImageView view=new ImageView(getApplicationContext());
            //view.setImageResource(arrAdImg[pos]);
            //以背景方式填充
            view.setBackgroundResource(arrAdImg[pos]);

            //将item的布局添加到容器
            container.addView(view);

            //返回item的布局对象
            return view;
        }

        //item 销毁的回调方法
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);

            Log.d(TAG,"销毁item-----"+position);

            //从容器中移除布局对象
            container.removeView((View)object);
        }
    }

}
