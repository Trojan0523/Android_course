package cn.buxiongyu.course.bxy417240310.Trojan_record.frag_dayweekmonth;

import java.util.List;

import cn.buxiongyu.course.bxy417240310.Trojan_record.db.ChartItemBean;
import cn.buxiongyu.course.bxy417240310.Trojan_record.db.DBManager;

public class WeekFragment extends BaseDWMFragment {

    public void loadData(int year,int month,int dayOfMonth,int dayOfWeek) {
        List<ChartItemBean> list1= DBManager.getChartListFromAccountByWeek(year,month,dayOfWeek,dayOfMonth,0);
        List<ChartItemBean> list2= DBManager.getChartListFromAccountByWeek(year,month,dayOfWeek,dayOfMonth,1);
        mDatas.clear();
        mDatas.addAll(list1);
        mDatas.addAll(list2);
        adapter.notifyDataSetChanged();
    }
}