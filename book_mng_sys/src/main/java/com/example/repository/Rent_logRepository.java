package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Rent_log;

public interface Rent_logRepository extends JpaRepository<Rent_log, Integer>{ //Jpaリポジトリの機能を持たせる。findAllとか使えるようになる。

}