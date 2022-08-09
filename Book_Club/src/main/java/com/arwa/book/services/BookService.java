package com.arwa.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arwa.book.models.BookClub;
import com.arwa.book.models.User;
import com.arwa.book.repositories.BookRepository;

@Service


public class BookService {
private final BookRepository bookRepository;
public BookService(BookRepository bookRepository) {
	this.bookRepository = bookRepository;
}


public List <BookClub> findallbooks(){
	return bookRepository.findAll();
}
public BookClub findbookbyid(Long id) {
	Optional<BookClub> potenialBookClub = bookRepository.findByid(id);
	if(potenialBookClub.isPresent()) {
		
		return potenialBookClub.get();
	}
	else {
		return null;
	}
	
	
}

public BookClub createbook(BookClub book , User user) {
	book.setUser(user);
	return bookRepository.save(book);
}

public BookClub edit(BookClub book , User user) {
	
	 book.setUser(user);
	 return bookRepository.save(book);
}


public void deletebook(Long id) {
	bookRepository.deleteById(id);
}



/*
 public  BookClub edit(BookClub newbook , BookClub oldbook ){
 oldbook.setTitle(newbook.getTitle()); 
  
  
  return bookRepository.save(oldbook);
  }
 
  
  
 */
}
