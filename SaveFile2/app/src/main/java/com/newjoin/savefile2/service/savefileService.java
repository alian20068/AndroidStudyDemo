package com.newjoin.savefile2.service;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by NewJoin on 2019/1/13.
 */

public class savefileService {
    //谷歌工程师推荐使用静态方法，因为静态方法在虚拟机里效率要高

    /**
     * 保存用户名 密码的业务方法
     * @param context 上下文
     * @param username 用户名
     * @param password 密码
     * @return true保存成功 false保存失败
     */
    public static boolean saveUserInfo(Context context, String username, String password) {
        try {
            //注意：/data/包名/ 是当前应用程序文件，不允许在此创建文件
            //File file = new File("/data/data/com.newjoin.savefile/userinfo.txt");

            //context.getFilesDir() //返回 /data/data/包名/files 的目录
            //context.getCacheDir() //返回 /data/data/包名/cache 的目录
            File file=new File(context.getFilesDir()+"/userinfo.txt");

            FileOutputStream fos = new FileOutputStream(file);
            //zhangsan##123
            fos.write((username + "##" + password).getBytes());
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
