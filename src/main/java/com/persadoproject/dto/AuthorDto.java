package com.persadoproject.dto;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class AuthorDto {
	@Getter @Setter private long authorId;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private String email;
	@Getter @Setter private Date dateOfBirth;
	@Getter @Setter private Set<BookWithPublisherDto> books;
	
	@Override
	public String toString() {
		return "AuthorApi [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + ", books=" + books + "]";
	}
	
}
