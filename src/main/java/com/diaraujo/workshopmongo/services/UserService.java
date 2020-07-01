package com.diaraujo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaraujo.workshopmongo.domain.User;
import com.diaraujo.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
}
