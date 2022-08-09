package com.arwa.book.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arwa.book.models.User;


@Repository
public interface UserRepository  extends CrudRepository <User,Long>{
	
	Optional<User> findByemail(String email);

}