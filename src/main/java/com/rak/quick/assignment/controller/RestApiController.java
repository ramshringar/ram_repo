package com.rak.quick.assignment.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rak.quick.assignment.service.UserAccessService;
import com.rak.quick.assignment.to.UserAccessTO;

@RestController
public class RestApiController {
	
	@Autowired
	private UserAccessService userAccessService;	
	
	@RequestMapping(value="/userAccess", consumes = "application/json", produces = "application/json",
			method = RequestMethod.POST)
	public void createUserAccess(@NotNull UserAccessTO userAccess) {
		userAccessService.createUserAccess(userAccess);
	}
	
	@RequestMapping(value="/allUserAccess", consumes = "application/json", produces = "application/json",
			method = RequestMethod.POST)
	public void createAllUserAccess(@NotNull List<UserAccessTO> allUserAccess) {
		userAccessService.createAllUserAccess(allUserAccess);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTest() {
		userAccessService.createUserAccess(getUserAccessTO());
		return "testing is successful";
	}
	
	private UserAccessTO getUserAccessTO() {
		UserAccessTO accessTO = new UserAccessTO();
		accessTO.setEmpId("Miller");
		accessTO.setAccessKey("TRMLLR");
		accessTO.setCountry("SG");
		accessTO.setSubUser("Miller");
		accessTO.setSubUserAccessKey("TRMLLR");
		accessTO.setSubUserCountry("SG");
		return accessTO;
	}
}
