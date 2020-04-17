package com.rak.quick.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rak.quick.assignment.to.UserAccessTO;
import com.rak.quick.assignment.domain.UserAccess;
import com.rak.quick.assignment.repository.UserAccessRepository;

@Service
public class UserAccessServiceImpl implements UserAccessService {
	
	private final UserAccessRepository userAccessRepository;
	
	public UserAccessServiceImpl(UserAccessRepository userAccessRepository) {
		this.userAccessRepository = userAccessRepository;
	}

	@Override
	public void createUserAccess(UserAccessTO ua) {
		userAccessRepository.save(new UserAccess(ua.getEmpId(), ua.getAccessKey(), ua.getCountry(),
				ua.getSubUser(), ua.getSubUserAccessKey(), ua.getSubUserCountry()));
		
		UserAccess user = userAccessRepository.findById(1l).get();
		System.out.println(user);
	}

	@Override
	public void createAllUserAccess(List<UserAccessTO> allUserAccess) {
		allUserAccess.stream().forEach(ua -> userAccessRepository.save(new UserAccess(ua.getEmpId(), ua.getAccessKey(), ua.getCountry(),
				ua.getSubUser(), ua.getSubUserAccessKey(), ua.getSubUserCountry())));
	}
}
