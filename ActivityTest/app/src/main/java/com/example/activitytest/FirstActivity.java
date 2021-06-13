package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    //在Activity中使用Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId())//通过getItemId 来判断点击的那个选项
        {
            case R.id.add_item:
                Toast.makeText(this, "you clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return  true;
    }

    //在Activity中使用Toast
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用显式Intent
                // Toast.makeText(FirstActivity.this,"you clicked Butron 1 Oh !!",Toast.LENGTH_SHORT).show();
               // Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //使用隐式Intent
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });
        //扩展的button2 ，使用外部类方法定义toast触发
        Button button2  = findViewById(R.id.button2);
        button2.setOnClickListener(new MyClick());



    }
    //用外部类来实现点击事件的代码如下
    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast t = Toast.makeText(FirstActivity.this, "you clicked Button2 by 外部类方法", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
