package com.it.myexception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class myaop {
    @Pointcut(value = "execution( Integer com.it.service.impl.userServiceImpl.getUserById(..))")
    public void a(){
    }
    @Before(value = "a()")
    public void bef(){
        System.out.println("前置通知");
    }
    @AfterReturning(value = "a()")
    public void after(){
        System.out.println("返回通知");
    }
    @After(value = "a()")
    public void fin(){
        System.out.println("最终通知");
    }
    @AfterThrowing(value = "a()")
    public void tho(){
        System.out.println("异常通知");
    }
    @Around(value = "a()")
    public Object around(ProceedingJoinPoint p) throws Throwable {
        System.out.println("环绕前通知");
        Object proceed = p.proceed();
        System.out.println("环绕后通知");
        return proceed;
    }
}
