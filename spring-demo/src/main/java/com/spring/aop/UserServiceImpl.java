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

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Description：
 *
 * @author caokeyu
 * @since 2021/3/2
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	String name;
	@Override
	public String getName() {
		return StringUtils.isEmpty(name) ? "cky" : name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
