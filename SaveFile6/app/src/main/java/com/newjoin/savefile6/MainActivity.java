package com.newjoin.savefile6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * Created by NewJoin on 2019-2-10 21:21:45.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ReadSd(View view) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "SD卡非挂载状态", Toast.LENGTH_SHORT).show();
            return;
        }
        //android.permission.READ_EXTERNAL_STORAGE 读外部存储的权限
        //4.0以前版本，读不需要权限
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/mysd.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            Toast.makeText(this, "读取成功" + str, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "读取失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void WriteSd(View view) {
        Log.d(TAG, "SD卡状态" + Environment.getExternalStorageState());
        Log.d(TAG, "枚举状态" + Environment.MEDIA_MOUNTED);

        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "SD卡非挂载状态", Toast.LENGTH_SHORT).show();
            return;
        }
        //android.permission.WRITE_EXTERNAL_STORAGE 写外部存储的权限
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/mysd.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("default".getBytes());
            fos.close();
            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
        }
    }
}
