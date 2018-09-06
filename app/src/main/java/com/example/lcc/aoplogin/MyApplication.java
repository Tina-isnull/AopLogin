package com.example.lcc.aoplogin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyApplication extends Application {
    public static boolean isLogin;
    public static LoginInterface loginSdk;
    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        loginSdk = new LoginSdk();
        mContext = getApplicationContext();
    }

    class LoginSdk implements LoginInterface {

        @Override
        public void mLoginSuccess() {
            Toast.makeText(mContext, "登陆成功", Toast.LENGTH_SHORT);
        }

        @Override
        public void mLoginFail() {
            Intent intent=new Intent(mContext, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
