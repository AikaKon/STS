package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="deposits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private Integer depositBalance;

}
