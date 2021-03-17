package com.persadoproject.service;

import java.util.List;

import com.persadoproject.dto.BookWIthDetailsDto;
import com.persadoproject.dto.BookWithPublisherDto;
import com.persadoproject.model.Book;

public interface BookService {
	List<BookWithPublisherDto> getBooksByPublisherId(long publisherId);
	List<BookWithPublisherDto> getVisibleBooksWithPublisher();
	BookWIthDetailsDto getBookByIsbn(String isbn);
	Book createBook(Book book);
	Book updateBook(String isbn, Book book);
	void deleteBook(String isbn);
}
