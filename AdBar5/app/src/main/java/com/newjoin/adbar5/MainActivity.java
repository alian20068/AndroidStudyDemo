package com.newjoin.adbar5;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by NewJoin on 2019-1-20 16:00:39.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager vpAd;
    private TextView tvTitle;
    private LinearLayout llcontainer;

    private int[] arrAdImg=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    private final String[] arrAdTitle={"标题1","标题2","标题3","标题4","标题5"};
    private int iPreviousPos;//上一个页面位置，默认0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpAd=findViewById(R.id.vpAd);
        tvTitle=findViewById(R.id.tvTitle);
        llcontainer=findViewById(R.id.llcontainer);

        //给 viewPager 设置数据
        vpAd.setAdapter(new MyAdapter());

        //实现可以无限左滑
        vpAd.setCurrentItem(arrAdImg.length*10000);

        //设置滑动监听
        vpAd.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滑动过程中
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当某个页面被选中
            @Override
            public void onPageSelected(int position) {
                int pos=position%arrAdImg.length;
                tvTitle.setText(arrAdTitle[pos]);

                Log.d(TAG,"当前页面位置......"+pos);

                //更新小圆点
                llcontainer.getChildAt(pos)
                    .setEnabled(true);//设置为可用
                //更新上一个圆点为不可用
                llcontainer.getChildAt(iPreviousPos)
                        .setEnabled(false);

                //记录上一个页面位置
                iPreviousPos=pos;
            }

            //滑动状态变化
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //初始化标题
        tvTitle.setText(arrAdTitle[0]);

        //动态添加小圆点
        for (int i=0;i<arrAdImg.length;i++) {
            ImageView view=new ImageView(this);
            //view.setImageResource(R.drawable.shape_point_normal);
            view.setImageResource(R.drawable.shape_point_selector);

            //设置margin
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            if(i!=0)
            {
                params.leftMargin=10;
                //设置不可用
                view.setEnabled(false);
            }
            view.setLayoutParams(params);


            //添加到布局容器里
            llcontainer.addView(view);
        }
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