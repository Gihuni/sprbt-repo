package com.kh.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ServiceLoggerAdvice {

	/*
	 * @After("execution(* com.kh.service.MemberDAOService*.*(..))") public void
	 * stopLog(JoinPoint jp) { log.info("stopLog"); log.info("stopLog : " +
	 * jp.getSignature()); if (jp.getArgs() != null) { log.info("stopLog : " +
	 * Arrays.toString(jp.getArgs())); } }
	 */

	@Around("execution(* com.kh.service.MemberDAOService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		//insert(), select(), delete(), selectAll() serviceImpl 실행하는 것
		//핵심관심 실행되는 부분
		Object result = pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		log.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
		return result;
	}

}
