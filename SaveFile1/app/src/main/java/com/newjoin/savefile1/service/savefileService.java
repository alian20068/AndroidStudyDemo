package com.newjoin.savefile1.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by NewJoin on 2019/1/13.
 */

public class savefileService {
    //谷歌工程师推荐使用静态方法，因为静态方法在虚拟机里效率要高
    public static boolean saveUserInfo(String username,String password) {
        try {
            //注意：/data/包名/ 是当前应用程序文件，不允许在此创建文件
            File file = new File("/data/data/com.newjoin.savefile/userinfo.txt");
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
