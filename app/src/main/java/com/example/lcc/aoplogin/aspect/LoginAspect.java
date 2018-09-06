package com.example.lcc.aoplogin.aspect;

import android.content.Context;
import android.util.Log;

import com.example.lcc.aoplogin.LoginInterface;
import com.example.lcc.aoplogin.MyApplication;
import com.example.lcc.aoplogin.annotation.CheckLogin;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class LoginAspect {

    @Pointcut("execution(@com.example.lcc.aoplogin.annotation.CheckLogin  * *(..))")
    public void executionCheckLogin() {
    }

    /**
     * 处理切面
     * @param joinPoint
     * @return
     */
    @Around("executionCheckLogin()")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {

//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String name = signature.getName(); // 方法名：test
//        Method method = signature.getMethod(); // 方法：public void com.lqr.androidaopdemo.MainActivity.test(android.view.View)
//        Class returnType = signature.getReturnType(); // 返回值类型：void
//        Class declaringType = signature.getDeclaringType(); // 方法所在类名：MainActivity
//        String[] parameterNames = signature.getParameterNames(); // 参数名：view
//        Class[] parameterTypes = signature.getParameterTypes(); // 参数类型：View
//        Log.d("Tina====>",name);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLogin checkLogin = signature.getMethod().getAnnotation(CheckLogin.class);
        if (checkLogin != null) {
            Context context = (Context) joinPoint.getThis();
            if (MyApplication.isLogin) {
                MyApplication.loginSdk.mLoginSuccess();
                return joinPoint.proceed();// 目标方法执行完毕
            } else {
                MyApplication.loginSdk.mLoginFail();
                return null;
            }
        }
        return joinPoint.proceed();
    }
}
