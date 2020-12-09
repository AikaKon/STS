package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("routePractice")
public class Hyoji {
//	Q1
		@GetMapping("top")
	    String test1() {
	        return  "top/index";
	    }
//Q2	
		@GetMapping("news")
		String test2(){
			return "news/index";
		}
//Q3
		
		@GetMapping("content/service")
		String test3(){
			return "content/service";
		}
//Q4
		@GetMapping("content/product")
		String test4(){
			return "content/product";
		}
//Q5
		@GetMapping("about/us")
		String test5(){
			return "aboutus";
		}
//Q6
		@GetMapping("recruit")
		String test6(){
			return "recruit";
		}
//Q7
		@GetMapping("contact/form/page")
		String test7(){
			return "content/contact";
		}
		
}
	   
