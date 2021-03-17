package com.persadoproject.dto;

import java.util.Set;

import com.persadoproject.model.Book;

import lombok.Getter;
import lombok.Setter;

public class PublisherDto {
	@Getter @Setter private Long publisherId;
	@Getter @Setter private String name;
	@Getter @Setter private String telephone;
	@Getter @Setter private String address;
	@Getter @Setter private Set<Book> books;
	
	@Override
	public String toString() {
		return "PublisherApi [publisherId=" + publisherId + ", name=" + name + ", telephone=" + telephone + ", address="
				+ address + ", books=" + books + "]";
	}
}
