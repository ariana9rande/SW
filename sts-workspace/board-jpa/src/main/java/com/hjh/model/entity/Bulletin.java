package com.hjh.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Component
public class Bulletin
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_no")
	private int id;
	
	@Column(length=100)
	private String title;
	
	@Column(length=2000)
	private String content;
	
	@CreationTimestamp
	private LocalDateTime writeDate;
	
	@ManyToOne
	private BoardUser writer;
}
