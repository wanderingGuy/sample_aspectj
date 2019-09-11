package com.wandering.sample.aspectj;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 示例基本用法 advice为Before
 */
@Aspect
public class MethodAspect {
    private static final String TAG = "ConstructorAspect";

    @Pointcut("call(* com.wandering.sample.aspectj.Animal.fly(..))")
    public void callMethod() {
        Log.e(TAG, "callMethod->");
    }

    @Before("callMethod()")
    public void beforeMethodCall(JoinPoint joinPoint) {
        Log.e(TAG, "getTarget->" + joinPoint.getTarget().toString());
        Log.e(TAG, "getThis->" + joinPoint.getThis());
    }
}