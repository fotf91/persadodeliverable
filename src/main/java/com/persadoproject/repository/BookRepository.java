package com.persadoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persadoproject.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    @Query(value = "SELECT b FROM Book b WHERE b.visible=TRUE AND b.publisherId = ?1")
    public List<Book> findBooksByPublisherId(Long publisherId);

    @Query(value = "SELECT b FROM Book b WHERE b.visible=TRUE AND b.publisherId != null")
    public List<Book> findAllByPublisherNotNullAndVisible ();
}