package com.xqy.wordofhonor.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.xqy.wordofhonor.MainActivity;
import com.xqy.wordofhonor.R;

public class WelcomeActivity extends AppCompatActivity {
    TextView tv;
    int count = 5;
    Handler handler = new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                count--;
                if (count == 0) {
//                    判断是否是第一次进入此应用，如果是第一次进入此应用，跳转到引导界面
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    tv.setText(String.valueOf(count));
                    handler.sendEmptyMessageDelayed(1,500);
                }
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv = findViewById(R.id.welcome_tv);
        handler.sendEmptyMessageDelayed(1,500);
    }
}
