package com.example.springdemo.security;

public enum AppUserPermission {
	LOX_READ("lox:read"),
	LOX_WRITE("lox:write"),
	ADM_READ("adm:read"),
	ADM_WRITE("adm:write");

	private final String permission;

	AppUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
