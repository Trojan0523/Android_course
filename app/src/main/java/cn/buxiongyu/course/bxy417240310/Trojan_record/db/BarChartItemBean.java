package cn.buxiongyu.course.bxy417240310.Trojan_record.db;
/*  用于描述柱状图的每个柱*/
public class BarChartItemBean {
//    年
    int year;
//    月
    int month;
//    日
    int day;
//    summary Money 同totalmoney
    float summoney;

    public BarChartItemBean(int year, int month, int day, float summoney) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.summoney = summoney;
    }

    public BarChartItemBean() {
    }
//  初始化对象的getter/setter方法,自动生成
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public float getSummoney() {
        return summoney;
    }

    public void setSummoney(float summoney) {
        this.summoney = summoney;
    }
}
