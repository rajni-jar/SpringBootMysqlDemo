package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.User;

@Service
public interface UserService {

	List<User> getUsers();

	User save(User user);

}
