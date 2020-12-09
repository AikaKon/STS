package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Rent_log;
import com.example.repository.Rent_logRepository;

@Service
public class Rent_logService {
	@Autowired //合致する型を探してくる。ついでにnewもしてくれる。便利。
	Rent_logRepository rent_logRepository;
    
    public List<Rent_log> getRent_logList() {
    
    	List<Rent_log> list = rent_logRepository.findAll(); //エンティティのデータを全件代入。Listに入れてる。（小文字のlistはここで使うだけの変数名）
    
    	return list;
    }
}