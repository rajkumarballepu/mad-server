package com.madcoder.madwatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madcoder.madwatch.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByGid(String gid);
}
