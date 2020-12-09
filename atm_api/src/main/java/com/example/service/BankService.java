package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Entity.Bank;
import com.example.repository.BankRepository;
@Service
public class BankService {
	
	@Autowired
	BankRepository bankRepository;
	
	//口座残高
	public Bank getBala(Integer id){		
		return bankRepository.findOne(id);
	}
	
	//口座開設
	public void accountOpen(Bank bank){
		  bankRepository.save(bank);
	}
	
	//入出金
	public void update(Bank bank){
		 bankRepository.save(bank);
	}
}
