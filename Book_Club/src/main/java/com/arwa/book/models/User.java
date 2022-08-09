package com.arwa.book.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import javax.persistence.OneToMany;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotEmpty(message= "username is requierd")
	@Size(min = 3 , max = 30 , message= "Username must be between 3 and 30 characters")
	private String username ; 
	
	@NotEmpty(message = "email is required")
    @Email(message="Please enter a valid email!")
	private String email;
	

	
	@NotEmpty(message = "password is required")
	@Size(min=8 , max=128 , message = "Password must be between 8 and 128 characters")
	private String password;
	
	//
	@Transient
	@NotEmpty(message="Confirm Password is required")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
	
	
	// one to many 
	@OneToMany(mappedBy="user",  fetch = FetchType.LAZY)
	private List<BookClub> books;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<BookClub> getBooks() {
		return books;
	}

	public void setBooks(List<BookClub> books) {
		this.books = books;
	}

	
	
	
	
	

	

}
