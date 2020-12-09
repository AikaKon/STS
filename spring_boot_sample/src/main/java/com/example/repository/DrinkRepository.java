package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Drink;
import java.util.ArrayList;
import java.util.List;


public interface DrinkRepository extends JpaRepository<Drink,Integer>{//Drinkエンティティーに詰められる
//機能を持っているfindなど

}
