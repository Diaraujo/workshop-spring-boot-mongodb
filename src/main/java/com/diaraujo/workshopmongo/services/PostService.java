package com.diaraujo.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaraujo.workshopmongo.domain.Post;
import com.diaraujo.workshopmongo.repository.PostRepository;
import com.diaraujo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	public PostRepository repository;
	
	
	public Post findById(String id) {
		Post post = repository.findById(id).orElse(null);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}
	
	
}
