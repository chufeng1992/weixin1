package com.weixin1.common.exception;

public class ControllerRuntimeException extends ContextRuntimeException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4294623584156890101L;

	/**
	 * Constructor
	 * 
	 * @param message
	 *            Error Message Description
	 */
	public ControllerRuntimeException(String message) {
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
	public ControllerRuntimeException(String message, Throwable cause) {
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
	public ControllerRuntimeException(String message, Throwable cause,
			String errorCode, Object[] parameters) {
		super(message, cause, errorCode, parameters);
	}
}
