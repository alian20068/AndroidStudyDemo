package com.newjoin.savefile2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.newjoin.savefile2.service.savefileService;

/**
 * Created by NewJoin on 2019-1-13 15:58:25.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private EditText etUserName;
    private EditText etPassword;
    private CheckBox cbSavePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etPassword);
        cbSavePassword=findViewById(R.id.cbSavePassword);
    }

    public void btnLogin_Click(View view) {
        String strUserName = etUserName.getText().toString();
        String strPassword = etPassword.getText().toString();

        if (TextUtils.isEmpty(strUserName) || TextUtils.isEmpty(strPassword)) {
            Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
        } else {
            if ("zhangsan".equals(strUserName) && "123".equals(strPassword)) {
                Toast.makeText(this, "登录成功", 0).show();

                if (cbSavePassword.isChecked()) {
                    Log.i(TAG, "需要保存用户名和密码");
                    savefileService.saveUserInfo(this,strUserName, strPassword);
                }
            } else {
                Toast.makeText(this, "登录失败，用户名或密码错误", 0).show();
            }
        }
    }
}
