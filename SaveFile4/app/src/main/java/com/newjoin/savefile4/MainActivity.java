package com.newjoin.savefile4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.newjoin.savefile4.service.savefileService;


/**
 * Created by NewJoin on 2019-2-10 14:28:15.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RadioGroup rgMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgMode = findViewById(R.id.rgMode);
    }

    public void btnSave_Click(View view) {
        int mode = 0;
        switch (rgMode.getCheckedRadioButtonId()) {
            case R.id.rbPrivate:
                mode = 1;
                break;
            case R.id.rbReadable:
                mode = 2;
                break;
            case R.id.rbWriteable:
                mode = 3;
                break;
            case R.id.rbPublic:
                mode = 4;
                break;
        }
        Log.d(TAG, "mode=" + mode);

        if (savefileService.SaveFile(this, mode)) {
            Toast.makeText(this, "保存成功", 0).show();
        } else {
            Toast.makeText(this, "保存失败", 0).show();
        }
    }
}
