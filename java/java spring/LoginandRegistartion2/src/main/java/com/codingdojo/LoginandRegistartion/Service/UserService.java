package com.codingdojo.LoginandRegistartion.Service;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.LoginandRegistartion.Repository.UserRepository;
import com.codingdojo.LoginandRegistartion.model.LoginUser;
import com.codingdojo.LoginandRegistartion.model.User;



@Service
public class UserService {
private final UserRepository userRepository;

public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
}

public User register(User newUser,BindingResult result) {
	if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
		result.rejectValue("email", "unique", "This email already exists");
	
		
	}
	if(!newUser.getPassword().equals(newUser.getConfirmPW())) {
		result.rejectValue("password", "matches", "the confirm password must match the entered password");
		return null;
	}
	
	if(result.hasErrors()) {
		return null;
	}
	
	
	else {
		String hashed = BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
				
	}
}

public User login(LoginUser LoginUser,BindingResult Result) {
	if(Result.hasErrors()) {
		return null;
	}
	Optional<User> potentialUser = userRepository.findByEmail(LoginUser.getEmail());
	if(!potentialUser.isPresent()) {
		Result.rejectValue("email", "unique", "Not signed in! Register now");
		return null;
	}
	User user = potentialUser.get();
	if(!BCrypt.checkpw(LoginUser.getPassword(),user.getPassword())) {
		Result.rejectValue("password", "matches", "the password is incorrect");
		return null;
	}
	else {
		return user;
	}
}

public Optional<User> findUser(Long id) {
	return userRepository.findById(id);
}
}