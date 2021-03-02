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

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description：
 *
 * @author caokeyu
 * @since 2021/3/2
 */
@ComponentScan(basePackages = "com.spring.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(App.class);
		UserService bean = applicationContext.getBean(UserService.class);
		bean.setName("zz");
		System.out.println(bean.getName());
	}
}