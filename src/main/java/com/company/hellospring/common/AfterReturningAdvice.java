package com.company.hellospring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
@Service
@Aspect
public class AfterReturningAdvice {
	@AfterReturning(pointcut="BeforeAdvice.allPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String argsStr = args != null && args.length > 0 ? args[0].toString() : "";
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");	
	}
}
