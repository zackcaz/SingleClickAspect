package com.lifecycle.singleclickaspect.singleclick;

import android.view.View;

import com.lifecycle.singleclickaspect.singleclick.annotation.SingleClick;
import com.lifecycle.singleclickaspect.singleclick.utils.ClickUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * 参考：https://www.jianshu.com/p/7b354eb8d0d3
 */
@Aspect
public class SingleClickAspect {
//    private static final long DEFAULT_TIME_INTERVAL = 5000;

    /**
     * 定义切点，标记切点为所有被@SingleClick注解的方法
     * 这里com.lifecycle.singleclickaspect.singleclick.annotation.SingleClick替换成自己注解的完整路径
     */
    @Pointcut("execution(@com.lifecycle.singleclickaspect.singleclick.annotation.SingleClick * *(..))")
    public void methodAnnotated() {
    }

    /**
     * 定义一个切面方法，包裹切点方法，注意注解中要写括号
     */
    @Around("methodAnnotated()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        //取出方法的参数
        View view = null;
        for (Object o : joinPoint.getArgs()) {
            if (o instanceof View) {
                view = (View) o;
                break;
            }
        }

        if (null == view) {
            return;
        }

        //取出方法的注解
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (!method.isAnnotationPresent(SingleClick.class)) {
            return;
        }

        SingleClick singleClick = method.getAnnotation(SingleClick.class);
        //判断是否是快速点击
        if (!ClickUtil.isFastDoubleClick(view, singleClick.value())) {
            //不是快速点击执行原方法
            joinPoint.proceed();
        }
    }
}
