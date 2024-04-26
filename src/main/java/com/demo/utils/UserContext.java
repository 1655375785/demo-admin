package com.demo.utils;

import com.demo.param.User;

public class UserContext {
	private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

	public static void setUser(User user) {
		userThreadLocal.set(user);
	}

	public static User getUser() {
		return userThreadLocal.get();
	}

	public static void removeUser() {
		userThreadLocal.remove();
	}
}
