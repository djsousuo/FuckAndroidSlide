package com.huruwo.hposed.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.huruwo.hposed.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView save_btn;

    private EditText ed_cookie, ed_xtt_token;

    private CheckBox checkBox;

    private SharedPreferences sp_cookie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_cookie = getSharedPreferences("ipport",
                Context.MODE_WORLD_READABLE);
        initView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn:
                String cookie = ed_cookie.getText().toString();
                String xtt_token = ed_xtt_token.getText().toString();
                SharedPreferences.Editor editor = sp_cookie.edit();
                editor.putString("cookie", cookie);
                editor.putString("xtt_token", xtt_token);
                boolean commit = editor.commit();
                if (commit) {
                    ToastUtils.showLong("修改成功", Toast.LENGTH_LONG);
                }
                break;
        }
    }

    private void initView() {
        checkBox = (CheckBox) findViewById(R.id.ck_toast);
        ed_cookie = (EditText) this.findViewById(R.id.ed_cookie);
        ed_xtt_token = (EditText) findViewById(R.id.ed_xtt_token);
        save_btn = (TextView) this.findViewById(R.id.save_btn);
        save_btn.setOnClickListener(this);
        String cookie = sp_cookie.getString("cookie", "");
        ed_cookie.setText(cookie);
        String xtt_token = sp_cookie.getString("xtt_token", "");
        ed_xtt_token.setText(xtt_token);
        checkBox.setChecked(sp_cookie.getBoolean("is_toast", false));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences.Editor editor = sp_cookie.edit();
                editor.putBoolean("is_toast", b);
                editor.commit();
            }
        });
    }



//            XSharedPreferences ipport = new XSharedPreferences("com.huruwo.hposed", "ipport");
//            synchronized (this) {
//                ipport.makeWorldReadable();
//                final boolean is_toast = ipport.getBoolean("is_toast", false);
//                final String cookie = ipport.getString("cookie", "cookie");
//                final String xtt_token = ipport.getString("xtt_token", "xtt_token");
//                if (StringUtils.isEmpty(cookie) && StringUtils.isEmpty(xtt_token)) {
//                    LogXUtils.e("未设置cookie token 无法hook", true);
//                    return;
//                }
//                LogXUtils.e("进入" + lpparam.packageName + "hook 是否hook" + is_toast, true);
//            }


}
