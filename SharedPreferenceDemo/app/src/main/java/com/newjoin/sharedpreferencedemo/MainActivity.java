package com.newjoin.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by NewJoin on 2019-2-14 21:19:14.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void Write(View view) {
        SharedPreferences sp = this.getSharedPreferences("testFile", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//得到一个编辑器，像一个Map集合
        editor.putString("username", "zhangsan");
        editor.putInt("age", 25);
        editor.commit();//类似事务提交

        Toast.makeText(this, "保存xml成功", Toast.LENGTH_SHORT).show();
    }

    protected void Read(View view) {
        SharedPreferences sp = this.getSharedPreferences("testFile", this.MODE_PRIVATE);
        String username = sp.getString("username", "默认值");
        int age = sp.getInt("age", 0);

        Toast.makeText(this, "姓名：" + username + "，年龄：" + age, Toast.LENGTH_LONG).show();
    }
}
