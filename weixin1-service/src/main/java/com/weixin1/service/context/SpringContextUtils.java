package com.weixin1.service.context;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtils implements ApplicationContextAware {
	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringContextUtils.class);

	/** springContext */
	private static ApplicationContext springContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtils.springContext = applicationContext;
	}

	/**
	 * 从spring容器里获取bean
	 * 
	 * @param beanId
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId) {
		T bean = null;
		try {
			if (null != SpringContextUtils.springContext
					&& StringUtils.isNotEmpty(StringUtils.trim(beanId))) {
				bean = (T) SpringContextUtils.springContext.getBean(beanId);
			}
		} catch (Exception e) {
			LOGGER.error("Can not get bean by id ['" + beanId
					+ "'] from spring application context!", e);
		}
		return bean;
	}
}
