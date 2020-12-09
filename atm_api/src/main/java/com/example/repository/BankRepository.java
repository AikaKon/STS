package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Entity.Bank;



public interface BankRepository extends JpaRepository<Bank,Integer>{
		
}