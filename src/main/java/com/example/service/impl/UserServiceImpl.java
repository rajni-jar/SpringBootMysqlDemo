package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repo.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		StreamSupport.stream(userRepository.findAll().spliterator(), false).parallel().forEach(s -> {
			System.out.println("Current Instance" + Thread.currentThread());
			users.add(s);
		});
		return users;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
