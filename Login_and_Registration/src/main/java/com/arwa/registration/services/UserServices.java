package com.arwa.registration.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.arwa.registration.models.LoginUser;
import com.arwa.registration.models.User;
import com.arwa.registration.repositories.UserRepository;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
  

@Service
public class UserServices {
	
	private final UserRepository  userRepository;
	
	public UserServices(UserRepository  userRepository) {
		this.userRepository = userRepository ;
	}
	
	public User regirster(User newUser , BindingResult result) {
		if(userRepository.findByemail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
			//result.rejectValue(Field,error code , default message);

		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
			//result.rejectValue(Field,error code , default message);

		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashed =  BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepository.save(newUser);
			
		}
		
		
	}
	
	public User login(LoginUser newLogin ,  BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		 Optional<User> potentialUser = userRepository.findByemail(newLogin.getEmail());
	        if(!potentialUser.isPresent()) {
	            result.rejectValue("email", "Unique", "Unknown email!");
	            return null;
	        }
	        User user = potentialUser.get();
	        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	            result.rejectValue("password", "Matches", "Invalid Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	            return user;
	        }
	    }
	 public User findUserById(Long id) {
	    	Optional<User> potentialUser = userRepository.findById(id);
	    	if(potentialUser.isPresent()) {
	    		return potentialUser.get();
	    	}
	    	else {
	    		return null;    		
	    	}
	    }
		
	}

