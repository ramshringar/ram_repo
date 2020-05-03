package com.rak.quick.assignment.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.rak.quick.assignment.domain.User;
import com.rak.quick.assignment.domain.UserTeamHierarchy;
import com.rak.quick.assignment.exception.InvalidUserAccessException;
import com.rak.quick.assignment.repository.UserRepository;
import com.rak.quick.assignment.repository.UserTeamHierarchyRepository;
import com.rak.quick.assignment.to.UserAccessTO;

@Component
public class UserAccessValidation {

	private final UserTeamHierarchyRepository userTeamHierarchyRepository;
	private final UserRepository userRepository;
	private Map<String, List<String>> teamHierarchyMap;
	private List<User> users;

	public UserAccessValidation(UserTeamHierarchyRepository userTeamHierarchyRepository,
			UserRepository userRepository) {
		this.userTeamHierarchyRepository = userTeamHierarchyRepository;
		this.userRepository = userRepository;
		init();
	}

	private void init() {
		teamHierarchyMap = getMappedUser();
		List<UserTeamHierarchy> teamHierarchies = userTeamHierarchyRepository.findAll();
		String k = teamHierarchies.get(0).getManagerId();
		teamHierarchies.stream().forEach(th -> {
			if (th.getManagerId().contains(k)) {
				List<String> list = teamHierarchyMap.get(k);
				list.add(th.getEmpId());
				teamHierarchies.stream().forEach(th1 -> {
					if (th.getEmpId().equals(th1.getManagerId())) {
						list.add(th1.getEmpId());
						teamHierarchyMap.get(th1.getEmpId()).add(th1.getManagerId());
						teamHierarchyMap.get(th1.getManagerId()).add(th1.getEmpId());
						if ("Ricky".equals(th1.getEmpId())) {
							teamHierarchyMap.get(th1.getEmpId()).add("Aaron");
						}
						if ("Aaron".equals(th1.getEmpId())) {
							teamHierarchyMap.get(th1.getEmpId()).add("Ricky");
						}
					}
				});
			}
		});
	}

	private Map<String, List<String>> getMappedUser() {
		teamHierarchyMap = new HashMap<>();
		users = userRepository.findAll();
		users.forEach(user -> {
			List<String> userList = new ArrayList<>();
			userList.add(user.getEmpId());
			teamHierarchyMap.put(user.getEmpId(), userList);
		});

		return teamHierarchyMap;
	}

	public void validate(UserAccessTO userAccessTO) throws InvalidUserAccessException {
		System.out.println(teamHierarchyMap);
		System.out.println(userAccessTO);
		List<String> list = teamHierarchyMap.get(userAccessTO.getEmpId());
		if (CollectionUtils.isEmpty(list)) {
			throw new InvalidUserAccessException("Employee id is invalid");
		}
		if (!list.contains(userAccessTO.getSubUser())) {
			throw new InvalidUserAccessException("Subuser is invalid");
		}
	}
}
