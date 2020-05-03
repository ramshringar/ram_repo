package com.rak.quick.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rak.quick.assignment.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
