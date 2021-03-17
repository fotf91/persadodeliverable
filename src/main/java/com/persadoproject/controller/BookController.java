package com.persadoproject.controller;

import java.util.List;

import com.persadoproject.dto.BookWIthDetailsDto;
import com.persadoproject.model.Book;
import com.persadoproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.persadoproject.dto.BookWithPublisherDto;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookWithPublisherDto>> getBooksByPublisherId(@RequestParam(required = true) long publisherId) {
		return ResponseEntity.ok().body(this.bookService.getBooksByPublisherId(publisherId));
	}

	@GetMapping(value = "/published", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookWithPublisherDto>> getVisibleBooksWithPublisher() {
		return ResponseEntity.ok().body(this.bookService.getVisibleBooksWithPublisher());
	}

	@GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookWIthDetailsDto> getBookByIsbn(@PathVariable String isbn) {
		return ResponseEntity.ok().body(this.bookService.getBookByIsbn(isbn));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
		return ResponseEntity.ok().body(this.bookService.createBook(book));
	}

	@PutMapping(value = "/{isbn}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@PathVariable(required = true) String isbn, @Valid @RequestBody Book book) {
		return ResponseEntity.ok().body(this.bookService.updateBook(isbn, book));
	}

	@DeleteMapping("/{isbn}")
	public HttpStatus deleteBook(@PathVariable String isbn){
		this.bookService.deleteBook(isbn);
		return HttpStatus.OK;
	}

}
