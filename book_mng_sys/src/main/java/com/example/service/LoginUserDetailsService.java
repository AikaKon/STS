package com.example.service;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; //入力無くてもOKにしてしまう？
import org.springframework.stereotype.Service;

@Service

public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String Emailadd) throws UsernameNotFoundException {
		User user = userRepository.findByEmailAddress(Emailadd);
		if (user == null) {
			throw new UsernameNotFoundException("The requested user is not found"); //Userオブジェクトがなければnullを返す
		}
		return new LoginUserDetails(user);
	}

}
