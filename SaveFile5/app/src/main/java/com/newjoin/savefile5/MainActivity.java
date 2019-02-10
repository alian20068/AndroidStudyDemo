package com.newjoin.savefile5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * Created by NewJoin on 2019-2-10 20:19:52.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String DirPath = "/data/data/com.newjoin.savefile4/files/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ReadDefault(View view) {
        try {
            File file = new File(DirPath + "default.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            Toast.makeText(this, "读取成功" + str, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "读取失败", Toast.LENGTH_SHORT).show();
        }
    }
    public void WriteDefault(View view) {
        try {
            File file = new File(DirPath + "default.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("default".getBytes());
            fos.close();
            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void ReadPrivate(View view) {
        try {
            File file = new File(DirPath + "private.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            Toast.makeText(this, "读取成功" + str, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "读取失败", Toast.LENGTH_SHORT).show();
        }
    }
    public void WritePrivate(View view) {
        try {
            File file = new File(DirPath + "private.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("private".getBytes());
            fos.close();
            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void ReadPublic(View view) {
        try {
            File file = new File(DirPath + "public.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str = br.readLine();
            Toast.makeText(this, "读取成功" + str, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "读取失败", Toast.LENGTH_SHORT).show();
        }
    }
    public void WritePublic(View view) {
        try {
            File file = new File(DirPath + "public.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("public".getBytes());
            fos.close();
            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
        }
    }
}
