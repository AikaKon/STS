package com.example.repository;


import com.example.domain.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface MakerRepository extends JpaRepository<Maker,Integer> {


}
