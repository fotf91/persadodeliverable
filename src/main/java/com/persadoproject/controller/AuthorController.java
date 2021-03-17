package com.persadoproject.controller;

import com.persadoproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.persadoproject.model.Author;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author){
		return ResponseEntity.ok().body(this.authorService.createAuthor(author));
	}

}
