package com.mh.naver.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class MyAspect implements InitializingBean{

	@Pointcut("execution(public * com.mh.naver(..))")
	public void targetMethod() {}
	
	@Around(value = "targetMethod()")
	public Object measure(ProceedingJoinPoint
			joinPoint) throws Throwable{
		try {
			System.out.println("객체 생성화..");
			Object result = joinPoint.proceed();
			return result;
		}
		finally {
			System.out.println("여기는 무조건 온다...");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("test");
	}
}
