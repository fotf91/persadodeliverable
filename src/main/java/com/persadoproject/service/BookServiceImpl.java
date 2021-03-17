package com.persadoproject.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.persadoproject.dto.BookWIthDetailsDto;
import com.persadoproject.exception.GeneralCustomException;
import com.persadoproject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persadoproject.dto.BookWithPublisherDto;
import com.persadoproject.model.Book;
import com.persadoproject.repository.BookRepository;
import com.persadoproject.utils.BookMapper;

import static java.lang.String.valueOf;

@Service
public class BookServiceImpl implements BookService{
	private final BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<BookWithPublisherDto> getBooksByPublisherId(long publisherId) {
		List<Book> books = bookRepository.findBooksByPublisherId(publisherId);
		if(books.isEmpty()){
			throw new ResourceNotFoundException(valueOf(publisherId));
		}

		Comparator<Book> authorLastNameSorting = Comparator.comparing(book -> book.getAuthor().getLastName());
		Comparator<Book> authorLastNameAndIdSorting = authorLastNameSorting.thenComparing(book -> book.getIsbn());

		return books.stream()
				.sorted(authorLastNameAndIdSorting)
				.map(BookMapper::bookToBookWithPublisherDto).collect(Collectors.toList());
	}

	@Override
	public List<BookWithPublisherDto> getVisibleBooksWithPublisher() {
		List<Book> books = bookRepository.findAllByPublisherNotNullAndVisible();
		if(books.isEmpty()){
			throw new ResourceNotFoundException();
		}

		Comparator<Book> authorLastNameSorting = Comparator.comparing(book -> book.getAuthor().getLastName());
		Comparator<Book> authorLastNameAndIdSorting = authorLastNameSorting.thenComparing(book -> book.getIsbn());

		return books.stream()
				.sorted(authorLastNameAndIdSorting)
				.map(BookMapper::bookToBookWithPublisherDto).collect(Collectors.toList());
	}

	@Override
	public BookWIthDetailsDto getBookByIsbn(String isbn) {
		Optional<Book> book = bookRepository.findById(isbn);

		if(!book.isPresent()) {
			throw new ResourceNotFoundException(isbn);
		} else {
			return BookMapper.bookToBookWithDetailsDto(book.get());
		}
	}

	@Override
	public Book createBook(Book book) {
		try {
			Optional<Book> bookExisting = bookRepository.findById(book.getIsbn());
			if(bookExisting.isPresent()){
				throw new GeneralCustomException("A book with the new ISBN ".concat(book.getIsbn()).concat(" already exists."));
			} else {
				return bookRepository.save(book);
			}
		} catch (Exception e) {
			throw new GeneralCustomException(e.getMessage());
		}
	}

	@Override
	public Book updateBook(String isbn, Book book) {
		try {
			Optional<Book> bookExisting = bookRepository.findById(isbn);
			if(bookExisting.isPresent()){
				if(!book.getIsbn().equals(isbn)){
					Optional<Book> sameBook = bookRepository.findById(book.getIsbn());
					if (sameBook.isPresent()) {
						throw new GeneralCustomException("A book with the new ISBN ".concat(book.getIsbn()).concat(" already exists."));
					}
				}

				Book bookNew = bookExisting.get();
				bookNew.setDescription(bookExisting.get().getDescription());
				bookNew.setCreationDate(bookExisting.get().getCreationDate());
				bookNew.setAuthorId(bookExisting.get().getAuthorId());
				bookNew.setPublisherId(bookExisting.get().getPublisherId());
				bookNew.setTitle(bookExisting.get().getTitle());
				bookNew.setVisible(bookExisting.get().isVisible());

				return bookRepository.save(book);
			} else {
				throw new ResourceNotFoundException(isbn);
			}
		} catch (Exception e) {
			throw new GeneralCustomException(e.getMessage());
		}
	}

	@Override
	public void deleteBook(String isbn) {
		try{
			Optional<Book> bookExisting = bookRepository.findById(isbn);

			if(bookExisting.isPresent()) {
				bookRepository.delete(bookExisting.get());
			} else {
				throw new ResourceNotFoundException(isbn);
			}
		} catch(Exception e) {
			throw new GeneralCustomException(e.getMessage());
		}
	}
	
}
