package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Book;
import com.example.form.BookForm;
import com.example.service.BookService;
import com.example.service.LoginUserDetails;

@Controller
public class BooksController {
	
	@Autowired  //  オートワイヤードでいちいちインスタンス生成しなくてよくなる。引数もそれっぽいのを探して入れてくれる！すげぇ！
	BookService bookService;
	
	@ModelAttribute
	BookForm setupForm() {
		return new BookForm();
	}
	  // フォームの初期化
	
	//一覧表示
	@GetMapping("/library") //libraryにアクセスしたらこの処理する
	// Model使うと画面にデータ渡せる。
	public String disp(Model model, @AuthenticationPrincipal LoginUserDetails loginUserDetails) { //userDetailsの中にログインユーザー情報入る。ここで引数が2つになり動かなそうに見えるが、オートワイヤードが全てよしなにやってくれる！
		//userDetailsにログイン中のユーザー情報入ってる。
		
		  // メソッド使ってるだけ。インスタンス生成はオートワイヤー度がやってる。
		  // データくれ。　サービスに要求
		List<Book> list = bookService.getBookList();//このメソッドでfindAllしてる
		
		model.addAttribute("user", loginUserDetails.getUser()); //modelにゲッター機能作る。"user"はHTMLで呼び出すときの名前
		  //画面にデータ渡すaddAttribute
		model.addAttribute("books", list); //HTMLで使うテーブル名、エンティティで宣言した名前。宣言していなければクラス名。listは渡す値
		  //これでコントローラーでもデータが取り出せる。
		
		return "library";
		  //リターン　ファイル名
	}
	
	@GetMapping("/borrow/{id}") //配置場所=Path URLの位置や場所のこと
	public String borrowBook(Model model, @PathVariable Integer id) { //PathVariableはいい感じで取得してくれる。
		
		Book book = bookService.getBook(id); //bookServiceのメソッド使ってる
		
		model.addAttribute("books", book); //model使いたいなら引数に指定すればいい。
		
		return "borrow";
	}
	@GetMapping("/return/{id}")
	public String kaesuBook(@PathVariable Integer id) {
		
		Book book = bookService.getBook(id);
		book.setRent(null);
		bookService.savebook(book);
		
		return "redirect:/library";
	}
	//返却履歴も作る。
}