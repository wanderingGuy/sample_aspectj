package com.wandering.sample.aspectj;

import android.util.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 示例基本用法 JoinPoint的API
 */
@Aspect
public class MethodAspect4 {
    private static final String TAG = "MethodAspect4";

    @Pointcut("call(* com.wandering.sample.aspectj.Animal.run(..))")
    public void callMethod() {
    }

    @Around("callMethod()")
    public void beforeMethodCall(ProceedingJoinPoint joinPoint) {
        Log.e(TAG, "around 1->");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.e(TAG, "around getTarget->" + joinPoint.getTarget().toString());// 被切面的animal对象
        Log.e(TAG, "around getThis->" + joinPoint.getThis()); //切面代码运行所在的类对象
        Log.e(TAG, "around getKind->" + joinPoint.getKind());//切面的类型 method-call
        Log.e(TAG, "around getSourceLocation->" + joinPoint.getSourceLocation());//源码位置 MainActivity.java:26
        Log.e(TAG, "around getDeclaringTypeName->" + joinPoint.getSignature().getDeclaringTypeName());//com.wandering.sample.aspectj.Animal
        Log.e(TAG, "around getModifiers->" + joinPoint.getSignature().getModifiers());//方法修饰符 1--public
        Log.e(TAG, "around getName->" + joinPoint.getSignature().getName());//方法名 run
        Log.e(TAG, "around getDeclaringType->" + joinPoint.getSignature().getDeclaringType());//Animal.class

    }

}