package com.weixin1.common.exception;

public class DaoAccessException extends ContextRuntimeException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1767759528189718007L;

	/**
	 * Constructor
	 * 
	 * @param message
	 *            Error Message Description
	 */
	public DaoAccessException(String message) {
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
	public DaoAccessException(String message, Throwable cause) {
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
	public DaoAccessException(String message, Throwable cause,
			String errorCode, Object[] parameters) {
		super(message, cause, errorCode, parameters);
	}
}