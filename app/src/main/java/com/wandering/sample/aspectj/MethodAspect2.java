package com.wandering.sample.aspectj;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 示例基本用法 execution vs. call
 */
@Aspect
public class MethodAspect2 {
    private static final String TAG = "MethodAspect2";

    @Pointcut("execution(* com.wandering.sample.aspectj.Animal.fly(..))")
    public void callMethod() {
    }

    @Around("callMethod()")
    public void beforeMethodCall(ProceedingJoinPoint joinPoint) {
        Log.e(TAG, "around 1->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.e(TAG, "around 2->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());

    }

}