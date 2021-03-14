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

package com.spring.mvc.handler;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.UrlPathHelper;

/**
 * Description：静态资源访问HandlerMapping
 *
 * @author caokeyu
 * @since 2021/3/14
 */
public class StaticResourceHandlerMapping implements HandlerMapping, ResourceLoaderAware, Ordered {

	private ResourceLoader resourceLoader;

	private UrlPathHelper urlPathHelper = new UrlPathHelper();

	private static final String RESOURCE_DIRECTORY = "classpath:static";

	@Override
	public HandlerExecutionChain getHandler(HttpServletRequest request) {
		String location = RESOURCE_DIRECTORY +
				getUrlPathHelper().getLookupPathForRequest(request);
		Resource resource = resourceLoader.getResource(location);
		InputStream in;
		try {
			in = resource.getInputStream();
		} catch (IOException e) {
			return null;
		}
		return new HandlerExecutionChain(in);
	}

	public UrlPathHelper getUrlPathHelper() {
		return urlPathHelper;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
}
