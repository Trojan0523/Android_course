package cn.buxiongyu.course.bxy417240310.Trojan_record;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent();
                intent.setClass(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();//销毁欢迎页面
            }
        },2000);//2秒后跳转
    }
}