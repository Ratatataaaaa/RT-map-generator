package com.example.springdemo.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.springdemo.security.AppUserPermission.*;

public enum AppUserRole {
	LOX(Sets.newHashSet()),
	ADM(Sets.newHashSet(ADM_READ, ADM_WRITE, LOX_READ, LOX_WRITE));

	private final Set<AppUserPermission> permissions;

	AppUserRole(Set<AppUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<AppUserPermission> getPermissions() {
		return permissions;
	}
}
