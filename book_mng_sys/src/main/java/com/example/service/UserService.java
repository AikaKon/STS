package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	@Autowired //合致する型を探してくる。ついでにnewもしてくれる。便利。
	UserRepository userRepository;
    
    public List<User> getUserList() {
    
    	List<User> list = userRepository.findAll(); //エンティティのデータを全件代入。Listに入れてる。（小文字のlistはここで使うだけの変数名）
    
    	return list;
    }
}