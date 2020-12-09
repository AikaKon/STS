package com.example.service;

// ログインしたユーザー情報置き場。

import com.example.domain.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private final User user;
	
	public LoginUserDetails(User user) {
		super(user.getEmailAddress(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

}
