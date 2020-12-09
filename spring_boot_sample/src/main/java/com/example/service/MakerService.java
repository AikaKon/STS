package com.example.service;

import com.example.domain.Maker;
import com.example.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakerService {
	@Autowired
	MakerRepository makerRepository;
	
	public List<Maker> findAll(){
		return  makerRepository.findAll();
	}

	
	

}
