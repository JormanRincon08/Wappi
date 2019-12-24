package com.automationpractice.wappi.exceptions;

public class LoginExc extends AssertionError {

	private static final long serialVersionUID = 1L;

	public static final String MESSAGE_PAGE_DO_NOT_LOADED = "The page could not be loaded";

	public LoginExc(String message, Throwable cause) {
		super(message, cause);
	}

}
