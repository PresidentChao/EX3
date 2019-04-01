package com.example.lenovo.ex3;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.color.black;
import static android.R.color.white;

public class AlertDialogAcitivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_acitivity);
        //实例化布局
        View view = LayoutInflater.from(this).inflate(R.layout.alertdialog_layout,null);
        //找到并对自定义布局中的控件进行操作的示例
        EditText account = (EditText) view.findViewById(R.id.editText2);
        account.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener()
                {            public void onClick(DialogInterface dialog, int id) {            }        })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener()
                {            public void onClick(DialogInterface dialog, int id) {                dialog.cancel();            }});

        TextView title = new TextView(this);
        title.setText("ANDROID APP");
        title.setPadding(5, 5, 5, 5);    //边距
        title.setGravity(Gravity.CENTER);    //位置
        title.setBackground(getResources().getDrawable(R.drawable.orange));
        title.setTextColor(getResources().getColor(white));
        title.setTextSize(30);  //字体的大小
        dialog.setCustomTitle(title);
        dialog.show();


    }
}
