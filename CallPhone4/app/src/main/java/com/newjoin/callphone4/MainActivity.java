package com.newjoin.callphone4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by NewJoin on 2019-1-6 17:02:05.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnDail_Click(View view) {
        MyCallPhone();
    }

    private void MyCallPhone(){
        EditText etPhoneNumber=MainActivity.this.findViewById(R.id.etPhoneNumber);
        String strPhoneNumber=etPhoneNumber.getText().toString();

        if(TextUtils.isEmpty(strPhoneNumber)) {
            Toast toast=Toast.makeText(MainActivity.this,"号码不能为空",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+strPhoneNumber));

        startActivity(intent);
    }
}
