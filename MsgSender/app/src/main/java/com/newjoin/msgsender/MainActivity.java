package com.newjoin.msgsender;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by NewJoin on 2019-1-6 17:08:32.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etPhoneNumber;
    private EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhoneNumber = MainActivity.this.findViewById(R.id.etPhoneNumber);
        etContent = MainActivity.this.findViewById(R.id.etContent);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                String strPhoneNumber = etPhoneNumber.getText().toString();
                String strContent = etContent.getText().toString();

                if (TextUtils.isEmpty(strPhoneNumber) || TextUtils.isEmpty(strContent)) {
                    Toast toast = Toast.makeText(MainActivity.this, "号码或内容不能为空", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    SmsManager smsManager = SmsManager.getDefault();

                    //短信内容分割成多条
                    ArrayList<String> arrContent = smsManager.divideMessage(strContent);
                    for (String content : arrContent) {
                        // 手机号
                        // 国内一般用不上，填null
                        // 内容70个汉字，或160个英文字符
                        // 短信是否发送失败
                        // 送达报告
                        smsManager.sendTextMessage(strPhoneNumber, null, content, null, null);
                    }
                }
                break;
            default:
                break;
        }
    }
}
