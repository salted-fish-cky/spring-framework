/*
 * Copyright (C) 2011-2021 ShenZhen iBOXCHAIN Information Technology Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of iBoxChain Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with iBoxChain inc.
 *
 */

package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author caokeyu
 * @since 2021/3/2
 */
@Aspect
@Component
public class MethondIntercetor {

	@Pointcut("execution(public * com.spring.aop.UserServiceImpl.*(..)))")
	public void pointCut() {

	}

	@Before("pointCut()")
	public void before() {
		System.out.println("before-------------");
	}

	@After("pointCut()")
	public void after() {
		System.out.println("after-------------");
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around1-------------");
		Object proceed = joinPoint.proceed();
		System.out.println("around2-------------");
		return proceed;
	}
}
