package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue  //  この設定をしているのでオートインクリメントの機能を使える。	←間違いです！！！これはただの目印！！！
    @Column(nullable = true, name = "") //どこに結合する？	いらない記述は消す。
    private Integer id;
    @Column(nullable = true) // nullを許容しない
    private String title; //本のタイトル
    @Column(nullable = true) // デフォルトはtrueなのでわざわざ書かなくてもよい。	なのでこの@Columnは消しても問題なし？
    private Integer rent; //貸し出したユーザーID入れる	誰も借りてないならNull
}