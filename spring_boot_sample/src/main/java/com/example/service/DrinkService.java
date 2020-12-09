package com.example.service;

import com.example.domain.Drink;
import com.example.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
	@Autowired
	DrinkRepository drinkRepository;
	
	//一覧表示
	public List<Drink> getDrink(){ //飲み物データを全部取りたい//メソッド
		
		return  drinkRepository.findAll();//findAllは取得
	}
	
	//詳細表示
	public Drink getDrinkichi(Integer id){//データをとってきてもらう
		
		return drinkRepository.findOne(id);
	}

	//新規追加・更新
	public void save(Drink drink) {//ドリンクエンティティ
		drinkRepository.save(drink);//データの登録	
	}
	//削除
	public void delete(Integer id){
		drinkRepository.delete(id);
	}

}
