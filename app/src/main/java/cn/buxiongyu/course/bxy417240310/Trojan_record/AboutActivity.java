package cn.buxiongyu.course.bxy417240310.Trojan_record;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.about_iv_back:
                finish();
                break;
        }
    }
}