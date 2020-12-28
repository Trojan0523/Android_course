package cn.buxiongyu.course.bxy417240310.Trojan_record.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import cn.buxiongyu.course.bxy417240310.Trojan_record.R;

public class BudgetDialog extends Dialog implements View.OnClickListener {
    ImageView cancelIv;
    Button ensureBtn;
    EditText moneyEt;
//    监听接口，用于数据回传，所有OnEnsureListener逻辑异曲同工
    public interface OnEnsureListener{
        public void onEnsure(float money);
    }
    OnEnsureListener onEnsureListener;
    public void setOnEnsureListener(OnEnsureListener onEnsureListener) {
        this.onEnsureListener = onEnsureListener;
    }

    public BudgetDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_budget);
        cancelIv=findViewById(R.id.dialog_budget_iv_error);
        ensureBtn=findViewById(R.id.dialog_budget_btn_ensure);
        moneyEt=findViewById(R.id.dialog_budget_et);
        cancelIv.setOnClickListener(this);
        ensureBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_budget_iv_error:
                cancel();
                break;
            case R.id.dialog_budget_btn_ensure:
//                获取输入数据数值
                String data = moneyEt.getText().toString();
                if (TextUtils.isEmpty(data)) {
                    Toast.makeText(getContext(), "输入数据不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                float money = Float.parseFloat(data);
                if (money<0) {
                    Toast.makeText(getContext(), "预算金额必须大于等于0！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (onEnsureListener!=null) {
                    onEnsureListener.onEnsure(money);
                }
                cancel();
                break;
        }
    }
//    设置Dialog尺寸与屏幕尺寸一致
    public void setDialogSize(){
//        获取当前窗口对象(对话框)
        Window window = getWindow();
//        获取窗口参数
        WindowManager.LayoutParams wlp = window.getAttributes();
//        获取屏幕宽度
        Display d = window.getWindowManager().getDefaultDisplay();
        wlp.width=(int)(d.getWidth());
        wlp.gravity= Gravity.BOTTOM;
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setAttributes(wlp);
        handler.sendEmptyMessageDelayed(1,100);
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //延时，自动弹出软键盘
            InputMethodManager inputMethodManager=(InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    };
}
