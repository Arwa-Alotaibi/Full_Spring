package com.arwa.book.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arwa.book.models.BookClub;


@Repository
public interface BookRepository  extends CrudRepository<BookClub,Long> {

	
	List <BookClub> findAll();
	
	Optional <BookClub> findByid(Long id);
}
