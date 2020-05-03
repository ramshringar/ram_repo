package com.rak.quick.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rak.quick.assignment.domain.UserTeamHierarchy;
@Repository
public interface UserTeamHierarchyRepository extends JpaRepository<UserTeamHierarchy, Long> {
	List<UserTeamHierarchy> findByManagerId(String managerId);
}
