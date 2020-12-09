package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	
	 User findByEmailAddress(String emailAddress); //エンティティのフィールドを参照するので、存在するフィールドの名前をつけないといけない

}
