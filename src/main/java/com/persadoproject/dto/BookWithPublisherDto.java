package com.persadoproject.dto;

import lombok.*;

@Data
@Builder
public class BookWithPublisherDto {
	private String title;
	private String description;
	private String isbn;
	private String authorsFullName;
}
