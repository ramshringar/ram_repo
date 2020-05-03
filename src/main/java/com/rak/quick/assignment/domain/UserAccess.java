package com.rak.quick.assignment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USERACCESS")
@Getter
@Setter
@Builder
@ToString
public class UserAccess {

	@GeneratedValue
	@Id
	private Long id;

	@Column(name="emp_id")
	private String empId;
	
	@Column(name="access_key")
	private String accessKey;
	
	@Column(name="country")
	private String country;
	
	@Column(name="sub_user")
	private String subUser;
	
	@Column(name="sub_user_access_key")
	private String subUserAccessKey;
	
	@Column(name="sub_user_country")
	private String subUserCountry;	
}
