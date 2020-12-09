package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity //スプリングセキュリティの基本設定の実行
public class SecurityConfig extends WebSecurityConfigurerAdapter { //アダプター付けると追加したい箇所だけオーバーライドして設定できる
	
	@Override
	public void configure(WebSecurity web) throws Exception { //configure(WebSecurity web)をオーバーライドするとセキュリティ無視など全体にかかわる設定ができる
		web.ignoring().antMatchers("/webjars/**", "/css/**", "/font/**", "/ul/**"); //セキュリティを無視する項目
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //認可の設定やログインログアウトに関する設定ができる
		http
			.authorizeRequests()
					.antMatchers("/loginForm").permitAll()
					.anyRequest().authenticated()
				.and()
				.formLogin() //form認証を有効化
				.loginProcessingUrl("/login") //ログインするときに行う処理↓ ここの処理を追加、変更する
					.loginPage("/loginForm") //ログインするときに使う場所
					.failureUrl("/loginForm?error") //エラー時の場所
					.defaultSuccessUrl("/library", true) //ログインできた時に表示する場所
					.usernameParameter("EmailAddress").passwordParameter("password") //HTMLでinputしたname属性の名前
				.and()
			.logout()
					.logoutSuccessUrl("/loginForm");
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder(); //パスワードをハッシュ化するための定義
	}
}