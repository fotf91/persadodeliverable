package com.persadoproject.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BOOK")
@Data
@NoArgsConstructor
public class Book {
	@Id
	@Column(name="ISBN", unique=true)
	@NotNull(message = "Isbn cannot be null")
	@NotEmpty(message = "Isbn cannot be empty")
	@Pattern(regexp="^\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}$",message="Isbn must have the format XXX-X-XX-XXXXXX-X where X is a digit.")
	private String isbn;
	@Column(name="TITLE")
	@NotNull(message = "Title cannot be null")
	@NotEmpty(message = "Title cannot be empty")
	@Size(min = 3, max = 50)
	private String title;
	@Column(name="DESCRIPTION")
	@NotNull(message = "Description cannot be null")
	@NotEmpty(message = "Description cannot be empty")
	@Size(min = 3, max = 250)
	private String description;
	@Column(name="VISIBLE")
	private boolean visible;
	@Column(name="CREATION_DATE")
	@NotNull(message = "Creation date cannot be null")
	private LocalDate creationDate;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AUTHOR_ID", referencedColumnName = "AUTHOR_ID", insertable = false, updatable = false)
	@JsonIgnore
    private Author author;
	@Column(name="AUTHOR_ID")
	@NotNull(message = "Author Id cannot be null")
	private Long authorId;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PUBLISHER_ID", referencedColumnName = "PUBLISHER_ID", insertable = false, updatable = false)
	@JsonIgnore
    private Publisher publisher;
	@Column(name="PUBLISHER_ID")
	private Long publisherId;

}
