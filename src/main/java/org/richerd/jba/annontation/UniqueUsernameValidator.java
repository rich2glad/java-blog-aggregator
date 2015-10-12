package org.richerd.jba.annontation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.richerd.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(userRepository == null){
			return true;
		}
		return userRepository.findByName(username)==null;
	}

}
