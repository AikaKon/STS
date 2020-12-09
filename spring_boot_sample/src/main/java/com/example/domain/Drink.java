package com.example.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drinks")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Drink {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private  String name;
	
	@Column(nullable=false)
	private  Integer price;
	
	@Column(nullable=false)
	private  Integer stock;
	
	@Column(nullable=false)
	private Integer makerId;
	
}
