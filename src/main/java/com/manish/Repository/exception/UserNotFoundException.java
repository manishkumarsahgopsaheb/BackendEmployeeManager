package com.manish.Repository.exception;

public class UserNotFoundException extends RuntimeException{
//	public UserNotFoundException(String message)
//	{
//		super(message);
//	}

	public void UserNotFoundException(String message) {
		System.out.println(message);
	}
}
