package com.example.form;

import lombok.Data;

@Data //getter,setterを自動生成してくれている
public class DrinkForm {//画面から入力された値を受け取る

	private  String drinkName;

	private  Integer price;
	
	private  Integer stock;
	
	private Integer makerId;

}
