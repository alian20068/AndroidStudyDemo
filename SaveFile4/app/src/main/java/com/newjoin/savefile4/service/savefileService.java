package com.newjoin.savefile4.service;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/10.
 */

public class savefileService {
    //谷歌工程师推荐使用静态方法，因为静态方法在虚拟机里效率要高

    /**
     * 保存文件
     *
     * @param context 上下文
     * @param mode    保存模式 1私有 2可读 3可写 4公开
     * @return true保存成功 false保存失败
     */
    @SuppressLint({"WorldWriteableFiles", "WorldReadableFiles"})
    public static boolean SaveFile(Context context, int mode) {
        try {
            FileOutputStream fos = null;
            String strData = "";

            switch (mode) {
                case 0:
                    File file = new File(context.getFilesDir() + "/default.txt");
                    fos = new FileOutputStream(file);
                    strData = "我是默认文件";
                    break;
                case 1:
                    fos = context.openFileOutput("private.txt", Context.MODE_PRIVATE);
                    strData = "我是私有文件";
                    break;
                case 2:
                    fos = context.openFileOutput("readable.txt", Context.MODE_WORLD_READABLE);
                    strData = "我是可读文件";
                    break;
                case 3:
                    fos = context.openFileOutput("writeable.txt", Context.MODE_WORLD_WRITEABLE);
                    strData = "我是可写文件";
                    break;
                case 4:
                    fos = context.openFileOutput("public.txt", Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
                    strData = "我是公开文件";
                    break;
            }
            fos.write(strData.getBytes());
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}