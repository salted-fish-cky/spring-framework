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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：
 *
 * @author caokeyu
 * @since 2021/3/2
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	String name;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public String getName() {
		return jdbcTemplate.queryForObject("select name from user where id = 1", String.class);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void setName(String name) {
		jdbcTemplate.update("update user set name = ? where id = 1", name);
	}
}
