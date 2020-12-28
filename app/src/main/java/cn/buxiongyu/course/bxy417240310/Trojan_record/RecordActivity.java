package cn.buxiongyu.course.bxy417240310.Trojan_record;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.buxiongyu.course.bxy417240310.Trojan_record.adapter.RecordPagerAdapter;
import cn.buxiongyu.course.bxy417240310.Trojan_record.frag_record.IncomeFragment;
import cn.buxiongyu.course.bxy417240310.Trojan_record.frag_record.OutcomeFragment;

public class RecordActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        tabLayout=findViewById(R.id.record_iv_tabs);
        viewPager=findViewById(R.id.record_vp);

        initPager();
    }

    private void initPager() {
//        初始化ViewPager页面的集合
        List<Fragment> fragmentList=new ArrayList<>();
//        创建收入和支出页面，置于fragment中
        OutcomeFragment outFrag=new OutcomeFragment();
        IncomeFragment inFrag=new IncomeFragment();
        fragmentList.add(outFrag);
        fragmentList.add(inFrag);
//        创建适配器
        RecordPagerAdapter pagerAdapter = new RecordPagerAdapter(getSupportFragmentManager(), fragmentList);
//        设置适配器
        viewPager.setAdapter(pagerAdapter);
//        将tabLayout和ViewPager进行关联
        tabLayout.setupWithViewPager(viewPager);
    }

    /*ImageView点击事件*/
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.record_iv_back:
                finish();
                break;
        }
    }
}