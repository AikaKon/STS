package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.SalesLog;
import java.util.List;


public interface SalesLogRepository extends JpaRepository<SalesLog,Integer> {

	List<SalesLog> findAllOrderBySaleTimeDesc();
}
