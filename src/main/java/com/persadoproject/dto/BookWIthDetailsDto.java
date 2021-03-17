package com.persadoproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookWIthDetailsDto {
    private String title;
    private String description;
    private String isbn;
    private String creationDate;
    private String authorsFullName;
    private String authorsEmail;
    private String authorsDateOfBirth;
    private String publisherName;
    private String publisherAddress;
}
