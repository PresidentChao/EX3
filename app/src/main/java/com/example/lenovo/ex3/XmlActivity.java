package com.example.lenovo.ex3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class XmlActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView = (TextView) findViewById(R.id.textView);


        int id = item.getItemId();

        //通过ID来响应菜单项
        if(id == R.id.small){
            textView.setTextSize(10);
        }

        if(id == R.id.middle){
            textView.setTextSize(16);
        }

        if(id == R.id.big){
            textView.setTextSize(20);
        }

        if (id == R.id.menuItem_2) {

            Toast.makeText(XmlActivity.this, "普通菜单项", Toast.LENGTH_SHORT).show();

            return true;

        }

        if(id == R.id.red){
            textView.setTextColor(Color.rgb(255, 0, 0));
        }

        if(id == R.id.black){
            textView.setTextColor(Color.rgb(0, 0, 0));
        }

        return super.onOptionsItemSelected(item);

    }



}
