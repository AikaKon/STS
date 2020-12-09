package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	@Autowired //合致する型を探してくる。ついでにnewもしてくれる。便利。
    BookRepository bookRepository;
    
    public List<Book> getBookList() {
    
    	List<Book> list = bookRepository.findAll(); //エンティティのデータを全件代入。Book型のListに入れてる。（小文字のlistはここで使うだけの変数名）
    
    	return list;
    }
    
    public Book getBook(Integer id) {
    	
    	Book one = bookRepository.findOne(id); //Bookの情報を一件取得。
    	
    	return one;
    	
    }
    
    public Book savebook(Book book) {
    	
    	return bookRepository.save(book);
    	
    }
}
//サービスにはエンティティを扱う為の処理を書く。実際使う処理書くのはコントロールで。