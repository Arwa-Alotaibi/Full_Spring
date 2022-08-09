package com.arwa.book.models;

import java.util.Date;

import javax.persistence.Column;
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

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

@Table(name="books")

public class BookClub {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Title must not be blank ")
	private String title;
	
	@NotEmpty(message="Author must not be blank ")
	private String author;
	
	@NotEmpty(message="thoughts must not be blank ")
	private String thoughts;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	 
	 
	 public BookClub() {}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getThoughts() {
		return thoughts;
	}



	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
	 
	 
	 
}
