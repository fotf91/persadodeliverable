package com.persadoproject.utils;

import com.persadoproject.dto.BookWIthDetailsDto;
import com.persadoproject.dto.BookWithPublisherDto;
import com.persadoproject.model.Book;

import java.time.format.DateTimeFormatter;

public class BookMapper {
    public static BookWithPublisherDto bookToBookWithPublisherDto(Book book) {
    	String bookDescription = "";
    	if(book.getDescription().length() > 100){
			bookDescription = book.getDescription().substring(0, 99).concat("...");
		} else {
			bookDescription = book.getDescription();
		}

		return BookWithPublisherDto
    			.builder()
    			.title(book.getTitle())
    			.description(bookDescription)
    			.isbn(book.getIsbn())
    			.authorsFullName(book.getAuthor().getFirstName().concat(" ").concat(book.getAuthor().getLastName()))
    			.build();
    }

    public static BookWIthDetailsDto bookToBookWithDetailsDto(Book book) {
		DateTimeFormatter formatterCreationDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return BookWIthDetailsDto
				.builder()
				.title(book.getTitle())
				.description(book.getDescription())
				.isbn(book.getIsbn())
				.creationDate(formatterCreationDate.format(book.getCreationDate()))
				.authorsFullName(book.getAuthor().getFirstName().concat(" ").concat(book.getAuthor().getLastName()))
				.authorsEmail(book.getAuthor().getEmail())
				.authorsDateOfBirth(Utilities.formatFullDateDescription(book.getAuthor().getDateOfBirth()))
				.publisherName(book.getPublisher().getName())
				.publisherAddress(book.getPublisher().getAddress())
				.build();
	}
}
