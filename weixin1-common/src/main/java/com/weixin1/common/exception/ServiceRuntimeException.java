/**
 * 文件名: ServiceRuntimeException.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月23日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.weixin1.common.exception;

public class ServiceRuntimeException extends ContextRuntimeException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6909094871906662558L;

	/**
	 * Constructor
	 * 
	 * @param message
	 *            Error Message Description
	 */
	public ServiceRuntimeException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 *            Error Message Description
	 * @param cause
	 *            Exception Cause
	 */
	public ServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 *            Error Message Description
	 * @param cause
	 *            Exception Cause
	 * @param errorCode
	 *            Error Code
	 * @param parameters
	 *            Error Code Message Parameters
	 */
	public ServiceRuntimeException(String message, Throwable cause,
			String errorCode, Object[] parameters) {
		super(message, cause, errorCode, parameters);
	}
}