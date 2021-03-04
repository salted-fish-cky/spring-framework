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

package com.spring.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：
 *
 * @author caokeyu
 * @since 2021/3/4
 */
@Service("userService2")
public class UserService2Impl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public String getName() {
		return jdbcTemplate.queryForObject("select name from user where id = 1", String.class);
	}

	@Override
	public String setName(String name) {
		return null;
	}
}
