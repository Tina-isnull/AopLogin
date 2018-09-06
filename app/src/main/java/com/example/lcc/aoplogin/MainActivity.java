package com.example.lcc.aoplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lcc.aoplogin.annotation.CheckLogin;

public class MainActivity extends AppCompatActivity {
    private Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.button_skip_one);
        MyApplication.isLogin = false;
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });
    }

    @CheckLogin
    public void test() {
        startActivity(new Intent(MainActivity.this, TwoActivity.class));
    }
}
