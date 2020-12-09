package com.example.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesLog {
	@Id
	@GeneratedValue
	private String id;
	
	@Column(nullable = false)
	private Date saleTime;
	
	@Column(nullable =false)
	private Integer drinkId;

}
