package cn.buxiongyu.course.bxy417240310.Trojan_record.frag_record;

import java.util.List;

import cn.buxiongyu.course.bxy417240310.Trojan_record.R;
import cn.buxiongyu.course.bxy417240310.Trojan_record.db.DBManager;
import cn.buxiongyu.course.bxy417240310.Trojan_record.db.TypeBean;

public class IncomeFragment extends BaseRecordFragment {
    //重写loadDataToGV实现子类不同效果
    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
        List<TypeBean> inlist = DBManager.getTypeList(1);
        typeList.addAll(inlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.in_qita_ls);
        accountBean.setTypename("其他");
        accountBean.setsImageId(R.mipmap.in_qita_ls);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(1);
        DBManager.insertItemToAccount(accountBean);
    }
}