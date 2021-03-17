package com.persadoproject.service;

import com.persadoproject.exception.GeneralCustomException;
import org.springframework.beans.factory.annotation.Autowired;

import com.persadoproject.model.Author;
import com.persadoproject.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author createAuthor(Author author){
		try {
			return authorRepository.save(author);
		} catch (Exception e) {
			if(e.getMessage().contains("could not execute statement; SQL [n/a]; ") && e.getMessage().contains("AUTHOR(EMAIL_ADDRESS)")){
				throw new GeneralCustomException("Email Address must be unique.");
			} else {
				throw new GeneralCustomException(e.getMessage());
			}
		}
	}

}
