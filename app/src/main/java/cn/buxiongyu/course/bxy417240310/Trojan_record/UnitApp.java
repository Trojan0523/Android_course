package cn.buxiongyu.course.bxy417240310.Trojan_record;

import android.app.Application;

import cn.buxiongyu.course.bxy417240310.Trojan_record.db.DBManager;

/*表示全局应用的类 -- 集合*/
public class UnitApp  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.initDB(getApplicationContext());
    }
}
