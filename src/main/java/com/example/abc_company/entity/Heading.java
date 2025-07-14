package com.example.abc_company.entity;

import jakarta.persistence.*;

@Entity
public class Heading {
	@Id
	private long id;
	
	@Column(nullable = false)
	private String text;
	
	public Heading() {}
	
	// Updating text
	public Heading(String text) {
		this.text = text;
	}
	
	// Getters and Setters
	public long getId() {
		return id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
