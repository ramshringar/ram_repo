package com.rak.quick.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rak.quick.assignment.domain.UserAccess;

public interface UserAccessRepository extends JpaRepository<UserAccess, Long>{
	List<UserAccess> findByCountry(String cntry);
}
