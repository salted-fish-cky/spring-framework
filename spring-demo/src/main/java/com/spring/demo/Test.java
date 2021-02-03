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

package com.spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description：
 *
 * @author caokeyu
 * @since 2021/2/3
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();;
				context.register(Test.class);
				context.refresh();
		System.out.println(context.getBean(Test.class));
		context.close();
	}
}
