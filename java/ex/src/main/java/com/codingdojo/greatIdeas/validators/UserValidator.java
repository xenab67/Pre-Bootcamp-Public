package com.codingdojo.greatIdeas.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.codingdojo.greatIdeas.models.User;
import com.codingdojo.greatIdeas.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	public void validate(Object target, Errors errors) {
		User user=(User) target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match","Passwords do not match! :)");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "unique", "email already taken! :/");
		}
	}
}
