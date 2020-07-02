package com.diaraujo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaraujo.workshopmongo.domain.User;
import com.diaraujo.workshopmongo.dto.UserDTO;
import com.diaraujo.workshopmongo.repository.UserRepository;
import com.diaraujo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		User user = repository.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User objBanco) {
		User userUp = findById(objBanco.getId());
		updateData(userUp, objBanco);
		return repository.save(userUp);
	}
	
	private void updateData(User userUp, User objBanco) {
		userUp.setName(objBanco.getName());
		userUp.setEmail(objBanco.getEmail());
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
