package com.rak.quick.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rak.quick.assignment.exception.InvalidUserAccessException;
import com.rak.quick.assignment.service.UserAccessService;
import com.rak.quick.assignment.to.UserAccessTO;

@RestController
public class RestApiController {
	
	@Autowired
	private UserAccessService userAccessService;	
	
	@RequestMapping(value="/userAccess", consumes = "application/json", produces = "application/json",
			method = RequestMethod.POST)
	public void createUserAccess(@RequestBody UserAccessTO userAccess) throws InvalidUserAccessException {
		userAccessService.createUserAccess(userAccess);
	}
	
	@RequestMapping(value="/allUserAccess", consumes = "application/json", produces = "application/json",
			method = RequestMethod.POST)
	public void createAllUserAccess(@RequestBody List<UserAccessTO> allUserAccess) throws InvalidUserAccessException {
		userAccessService.createAllUserAccess(allUserAccess);
	}
	
	//TODO Only testing purpose
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public UserAccessTO getTest() throws InvalidUserAccessException {
		userAccessService.createUserAccess(getUserAccessTO());
		return getUserAccessTO();
	}
	
	//TODO Testing purpose
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
