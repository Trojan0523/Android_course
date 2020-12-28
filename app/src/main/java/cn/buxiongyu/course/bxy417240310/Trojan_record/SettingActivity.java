package cn.buxiongyu.course.bxy417240310.Trojan_record;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import cn.buxiongyu.course.bxy417240310.Trojan_record.db.DBManager;
import cn.buxiongyu.course.bxy417240310.Trojan_record.utils.FileUtils;

public class SettingActivity extends AppCompatActivity {
    String backupDBPath;
    String currentDBPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        backupDBPath=getExternalFilesDir(null).getPath() + "/ledger.db";
        currentDBPath="/data/data/"+getPackageName()+"/databases/ledger.db";
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_iv_back:
                finish();
                break;
            case R.id.setting_tv_clear:
                showDeleteDialog();
                break;
        }
    }


    //importing database
    private void importDB() {

        try {
            File currentDB=new File(currentDBPath);
            File backupDB=new File(backupDBPath);

            FileUtils.checkFilePath(backupDB, false);
            FileUtils.checkFilePath(currentDB, false);
            if (!backupDB.exists()) {
                Toast.makeText(getBaseContext(), "要导入的文件不存在", Toast.LENGTH_LONG).show();
                return;
            }
            FileUtils.deleteFile(currentDB);
            if(FileUtils.copyFile(backupDB,currentDB)==0) {
                Toast.makeText(getBaseContext(), "导入成功", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getBaseContext(), "导入失败", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "导入失败", Toast.LENGTH_LONG).show();
        }
    }
    private void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示信息")
                .setMessage("您确定要删除所有记录吗?\n注意，删除后无法恢复，请慎重选择！")
                .setPositiveButton("取消",null)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBManager.deleteAllAccount();
                        Toast.makeText(SettingActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }
}