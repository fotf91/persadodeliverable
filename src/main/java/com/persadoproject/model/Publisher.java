package com.persadoproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PUBLISHER")
@Data
@NoArgsConstructor
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PUBLISHER_ID")
	private Long publisherId;
	@Column(name="NAME")
	@NotNull(message = "Publisher Name cannot be null")
	@NotEmpty(message = "Publisher Name cannot be empty")
	@Size(min = 3, max = 50)
	private String name;
	@Column(name="TELEPHONE")
	@NotNull(message = "Telephone cannot be null")
	@NotEmpty(message = "Telephone Name cannot be empty")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Telephone can contain only digits and it must have length of 10.")
	private String telephone;
	@Column(name="ADDRESS")
	@NotNull(message = "Address cannot be null")
	@NotEmpty(message = "Address Name cannot be empty")
	@Size(min = 3, max = 100)
	private String address;
}
