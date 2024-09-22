package com.madcoder.madwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madcoder.madwatch.model.User;
import com.madcoder.madwatch.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/moviez/api/user")
public class UserController {
	
	private UserRepository userRepo;
	
	@Autowired
	private void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@GetMapping("/")
	public String userHome() {
		return "This is user home";
	}
	
	@PostMapping("/")
	public User postMethodName(@RequestBody User entity) {
//		System.out.println(entity);
		User byGid = userRepo.findByGid(entity.getGid());
		System.out.println(byGid);
		if(byGid == null) {
			userRepo.save(entity);
			return userRepo.findByGid(entity.getGid());
		}
		return byGid;
	}
	
}
