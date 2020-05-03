package com.rak.quick.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rak.quick.assignment.domain.UserAccess;
import com.rak.quick.assignment.exception.InvalidUserAccessException;
import com.rak.quick.assignment.repository.UserAccessRepository;
import com.rak.quick.assignment.to.UserAccessTO;
import com.rak.quick.assignment.validation.UserAccessValidation;

@Service
public class UserAccessServiceImpl implements UserAccessService {

	private final UserAccessRepository userAccessRepository;
	private final UserAccessValidation validation;

	public UserAccessServiceImpl(UserAccessRepository userAccessRepository, UserAccessValidation validation) {
		this.userAccessRepository = userAccessRepository;
		this.validation = validation;
	}

	@Override
	public void createUserAccess(UserAccessTO ua) throws InvalidUserAccessException {
		validation.validate(ua);
		userAccessRepository.save(getUserAccess(ua));
	}

	@Override
	public void createAllUserAccess(List<UserAccessTO> allUserAccess) throws InvalidUserAccessException {
		allUserAccess.stream().forEach(ua -> {
			try {
				validation.validate(ua);
			} catch (InvalidUserAccessException e) {
				throw new RuntimeException();
			}
			userAccessRepository.save(getUserAccess(ua));
		});
	}

	private UserAccess getUserAccess(UserAccessTO ua) {
		return UserAccess.builder().empId(ua.getEmpId()).accessKey(ua.getAccessKey()).country(ua.getCountry())
				.subUser(ua.getSubUser()).subUserAccessKey(ua.getSubUserAccessKey())
				.subUserCountry(ua.getSubUserCountry()).build();
	}
}