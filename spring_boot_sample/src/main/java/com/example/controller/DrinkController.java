package com.example.controller;

import java.util.List;

import com.example.domain.Drink;
import com.example.domain.SalesLog;
import com.example.form.DrinkForm;
import com.example.repository.DrinkRepository;
import com.example.service.DrinkService;
import com.example.service.SalesLogService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/drinks")
public class DrinkController {
	@Autowired
	DrinkService drinkService;//DrinkServiceドリンク返してくれる インスタンス作ってくれてる
	
	@Autowired
	SalesLogService salesLogService;
	
	@ModelAttribute //ここで使いたいからFormを使う準備
	DrinkForm setUpForm(){
		return new DrinkForm();//DrinkFormのインスタンスを返している 
	}
	
	
	//一覧表示　
	@GetMapping
	public String list(Model model){
		List<Drink> drinks = drinkService.getDrink();//メソッド呼び出してる	
		model.addAttribute("drinkList",drinks);//画面にデータ渡してる addAttributeを使うためにModelを使っている
		return "drinks/drink";
	}
	
	//詳細表示
	@GetMapping("/{id}")
	public String ichiran(Model model,@PathVariable Integer id){
		//1件分のデータを表示したい、idに紐づいたデータ
		//データを画面に表示する
		Drink one = drinkService.getDrinkichi(id);//Drinkクラスが１レコード分をとってきてもらう
		model.addAttribute("ichiDrink",one);//"ichiDrink"は変数名的な役割
		return "drinks/OneDrink";
	}
	
	//新規追加画面表示
	@GetMapping("/create")
	public String create(){//表示したいだけ
		return "drinks/newlist";
	}
	
	//新規追加実行
	@PostMapping("/store")
	public String insert(DrinkForm form,Model model){
		//入力したデータをDBに登録したい
		
		//formが入力値をもとに登録するためのデータを作る
		Drink drink = new Drink();//インスタンスを作成する
		
		drink.setName( form.getDrinkName());//, DrinkFormのゲッターから取得,DrinkエンティティのセッターにDrinkFormを入れる
		drink.setPrice(form.getPrice());
		drink.setStock(form.getStock());
		drink.setMakerId(form.getMakerId());
		
		//作成したデータをDBへ登録
		 drinkService.save(drink);
		return list(model); //一覧表示のメソッドを呼んだ
	}
	


	//編集画面
	@GetMapping("/edit/{id}")
	public String hensyu(DrinkForm form,@PathVariable Integer id, Model model){
		System.out.println("-----------------------");
		//更新対象のデータの取得→更新対象のid
		Drink one = drinkService.getDrinkichi(id);//Drinkクラスが１レコード分の情報
		form.setDrinkName(one.getName());
		form.setPrice(one.getPrice());
		form.setStock(one.getStock());
		form.setMakerId(one.getMakerId());
		
		model.addAttribute("drinkId",id);
		return "drinks/edit";
	}
	
	//編集更新実行
	@PutMapping("/update/{id}")
	public String upDate(Model model, @PathVariable Integer id,DrinkForm form){
		
		Drink drink = new Drink();
		drink.setId(id);
		drink.setName(form.getDrinkName());
		drink.setPrice(form.getPrice());
		drink.setStock(form.getStock());
		drink.setMakerId(form.getMakerId());
		
		drinkService.save(drink);
		return list(model);//最後一覧表示
	}

	//削除
	@DeleteMapping("/destroy")
	public String delete(@RequestParam Integer id){
		drinkService.delete(id);		
		return "redirect:/drinks";
	}
	
	//ログ表示
	@GetMapping("/logs")
	public String log(Model model){
		
		List<SalesLog> sale = salesLogService.sale();//メソッド呼び出してる	
		model.addAttribute("sales",sale);//画面にデータ渡してる addAttributeを使うためにModelを使っている
		return "drinks/logs";
	}
	
	

}
	
