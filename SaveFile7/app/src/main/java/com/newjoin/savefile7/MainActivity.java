package com.newjoin.savefile7;

import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

/**
 * Created by NewJoin on 2019-2-14 20:45:48.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = findViewById(R.id.tvContent);
        tvContent.setText(getSdInfo() + "\n" + getRomSpaceInfo());
    }

    private String getSdInfo() {
        File path = Environment.getExternalStorageDirectory(); //获取SD卡目录
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        long availableBlocks = stat.getAvailableBlocks();

        long totalSize = blockSize * totalBlocks;
        long availableSize = blockSize * availableBlocks;

        String strTotal = android.text.format.Formatter.formatFileSize(this, totalSize);
        String strAvail = android.text.format.Formatter.formatFileSize(this, availableSize);

        return "SD卡容量：" + strTotal + "，可用：" + strAvail;
    }

    private String getRomSpaceInfo() {
        File path = Environment.getDataDirectory(); //获取内存目录
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        long availableBlocks = stat.getAvailableBlocks();

        long totalSize = blockSize * totalBlocks;
        long availableSize = blockSize * availableBlocks;

        String strTotal = android.text.format.Formatter.formatFileSize(this, totalSize);
        String strAvail = android.text.format.Formatter.formatFileSize(this, availableSize);

        return "手机内存：" + strTotal + "，可用：" + strAvail;
    }
}
