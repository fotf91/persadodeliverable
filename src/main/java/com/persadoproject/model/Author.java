package com.persadoproject.model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Entity
@Table(name="AUTHOR")
@Data
@NoArgsConstructor
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AUTHOR_ID")
	private Long authorId;
	@Column(name="FIRST_NAME")
	@NotNull(message = "First Name cannot be null")
	@NotEmpty(message = "First Name cannot be empty")
	@Size(min = 3, max = 50)
	private String firstName;
	@Column(name="LAST_NAME")
	@NotNull(message = "Last Name cannot be null")
	@NotEmpty(message = "Last Name cannot be empty")
	@Size(min = 3, max = 50)
	private String lastName;
	@Column(name="EMAIL_ADDRESS", unique=true)
	@NotNull(message = "Email address cannot be null")
	@NotEmpty(message = "Email address cannot be empty")
	@Pattern(regexp="^(.+)@(\\S+)$",message="Email must have a valid format")
	@Size(min = 3, max = 50)
	private String email;
	@Column(name="DOB")
	@NotNull(message = "Date of birth cannot be null")
	private LocalDate dateOfBirth;
}
