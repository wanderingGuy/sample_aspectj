package com.wandering.sample.aspectj;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * if条件、args参数
 */
@Aspect
public class MethodAspect8 {
    private static final String TAG = "MethodAspect8";

    @Pointcut("call(boolean *.*(int)) && args(i) && if()")
    public static boolean someCallWithIfTest(int i, JoinPoint jp) {
        // any legal Java expression...
        return i > 0 && jp.getSignature().getName().startsWith("setAge");
    }

    @Before("someCallWithIfTest(i, jp)")
    public void aroundMethodCall(int i, JoinPoint jp) {
        Log.e(TAG, "before if ");
    }

}
