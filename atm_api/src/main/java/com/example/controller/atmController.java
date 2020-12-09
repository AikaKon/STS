package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Conversion.AmountConversion;
import com.example.Conversion.BalanceConversion;
import com.example.Conversion.BankConversion;
import com.example.Entity.Bank;
import com.example.service.BankService;

@RestController//jsonやXML等を返すWebAPI用のコントローラで使用する
@RequestMapping("bankTrading")
public class atmController {
	
		
	@Autowired//newしてくれる
	BankService bankService;

	
	//口座開設
	@PostMapping("/accountOpening")
	public BankConversion opening(){
		//インスタンス生成
		Bank bank = new Bank();
		//残高を０にする
	    bank.setDepositBalance(0);
	    //アカウント開設のメソッドに情報入れた
	    bankService.accountOpen(bank);
	    //表示を変えたいだけ
	    BankConversion conversion = new BankConversion();
	    conversion.setId(bank.getId());
	    conversion.setBalance(bank.getDepositBalance());
	    return conversion;
	}

	@GetMapping
	public void a(@PathVariable Integer id,Model model){
		Bank bala = bankService.getBala(id);
		model.addAttribute("id",bala);
		return;
	}
		
	//残高照会
	@GetMapping("/{id}")
	public BalanceConversion balance(@PathVariable Integer id){
		//bankテーブルから一件とってきてる
		Bank bala = bankService.getBala(id);
		
		//balance：10000表示にしたい
		BalanceConversion balance = new BalanceConversion();
		//セットする
		balance.setBalance(bala.getDepositBalance());
		return balance;
	}
	
	
	//貯金
	@PutMapping("/depositMoney/{id}")
	public BalanceConversion deposit(@PathVariable Integer id,@RequestBody AmountConversion amount){ 
		//口座の取得
		 Bank depo = bankService.getBala(id);
		//今ある残高に加算させたい amountは入金されたものを受け取る
		 depo.setDepositBalance(depo.getDepositBalance() + amount.getAmount());
		//更新処理
		 bankService.update(depo);
		//インスタンス生成
		 BalanceConversion bala = new BalanceConversion();
		//balanceメソッドにセットする
		 bala.setBalance(depo.getDepositBalance()); 
		 return bala;
	}
	
	
	//引き出し
	@PutMapping("/withdrawal/{id}")
	public BalanceConversion withdrawal(@PathVariable Integer id,@RequestBody AmountConversion amount){
		//口座の情報取得
		Bank depo = bankService.getBala(id);
		//今ある残高から出金金額を引きたい
		depo.setDepositBalance(depo.getDepositBalance() - amount.getAmount());
		//更新処理呼んだ.そこに詰め込む
		bankService.update(depo);
		//インスタンス作った
		BalanceConversion bala = new BalanceConversion();
		//balanceメソッドにセットした
		bala.setBalance(depo.getDepositBalance());
		return bala;
	}
	//1ページhtmlを作る
}
