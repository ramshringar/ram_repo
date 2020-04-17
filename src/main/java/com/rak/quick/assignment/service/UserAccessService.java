package com.rak.quick.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rak.quick.assignment.to.UserAccessTO;

@Service
public interface UserAccessService {

	public void createUserAccess(UserAccessTO access);

	public void createAllUserAccess(List<UserAccessTO> access);
}
