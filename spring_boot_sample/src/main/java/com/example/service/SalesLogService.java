package com.example.service;

import com.example.domain.SalesLog;
import com.example.repository.SalesLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesLogService {
	@Autowired
	SalesLogRepository salesLogRepository;
	
	
	public List<SalesLog> getSale(){
		return  salesLogRepository.findAll();
	}
	
	public List<SalesLog> sale(){
		return salesLogRepository.findAllOrderBySaleTimeDesc();
		
	}


}
