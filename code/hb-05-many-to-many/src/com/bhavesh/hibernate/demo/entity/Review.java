package com.bhavesh.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	// define the fields
	// annotate the fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	// define the constructors
	
	public Review() {
	}

	public Review(String comment) {
		this.comment = comment;
	}

	// generate getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	// generate toStrin() method
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
}
