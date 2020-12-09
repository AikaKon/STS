package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data //ゲッターセッター作ってくれる。超便利。必須レベル
@NoArgsConstructor //デフォルトコンストラクタを作ってくれる。何もしなければ作ってくれるものだが大抵何かするのであると記述が減って便利。	※デフォルトコンストラクタは親クラスを参照する←重要そうだ
@AllArgsConstructor //全メンバへ代入する引数付きのコンストラクタ作成する。User(それぞれのフォールド名)で値の代入ができる。	※今は使わない。あると便利だから書いているだけ。
@Entity //エンティティクラスだよ
@Table(name = "users") //テーブル名。宣言しなければクラス名がテーブル名になる。あとで便利。長かったら不便なのでしっかり宣言しておく。
@ToString(exclude = "rent_logs") //オーバーフローエラーを防ぐため書く。excludeは除外するという意味。ToStringメソッドからrent_logsフィールドの出力を除外する。
public class User {
	
	@Id //エンティティではプライマリーキーをクラス内で必ず設定しなければならないので書く。
	@GeneratedValue //これは"DBでIDが振り分けられているよ"という目印をほかの人が見てもわかりやすいように付けているだけ。	ただの目印なので（）で機能を付けなくてもいい。
	private Integer id;
	@JsonIgnore
	@Column(name = "mail_ad") //MySQLのカラム名を指定する。最初からSQLのカラム名と同じだったらいらない。
	private String emailAddress;
	@JsonIgnore //JSON出力する場合に無視する項目。Ignoreは無視するという意味。
	@Column(name = "pass")
	private String password;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user") //
	private List<Rent_log> rent_logs;
}