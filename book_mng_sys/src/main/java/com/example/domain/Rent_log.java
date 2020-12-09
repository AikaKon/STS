package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rent_logs")
public class Rent_log {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date rent_time;
	private Integer user_id;
	private Integer book_id;
	private Date return_plans;
	private Date return_time;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "users,id")
	private User user;

}
