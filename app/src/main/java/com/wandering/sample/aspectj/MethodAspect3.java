package com.wandering.sample.aspectj;

import android.util.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 示例基本用法 获取参数getArgs process(args)
 */
@Aspect
public class MethodAspect3 {
    private static final String TAG = "MethodAspect3";

    @Pointcut("execution(* com.wandering.sample.aspectj.Animal.run(..))")
    public void callMethod() {
    }

    @Around("callMethod()")
    public void beforeMethodCall(ProceedingJoinPoint joinPoint) {
        Log.e(TAG, "around 1->");
        Object[] args = joinPoint.getArgs();
        int params = 0;
        for (Object arg : args) {
            Log.e(TAG, "around arg->" + arg);
            params = (int) arg / 10;
        }
        try {
            joinPoint.proceed(new Object[]{params});//改变参数值
//            joinPoint.proceed();//默认使用原参数调用
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}