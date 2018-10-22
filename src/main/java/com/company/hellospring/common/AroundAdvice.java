package com.company.hellospring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Around("BeforeAdvice.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		//서비스 메서드 호출
		Object returnObj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println(methodName + " 수행시간 : " + stopwatch.getTotalTimeMillis()/1000.0 + "초");
		
		return returnObj;
	}
}
