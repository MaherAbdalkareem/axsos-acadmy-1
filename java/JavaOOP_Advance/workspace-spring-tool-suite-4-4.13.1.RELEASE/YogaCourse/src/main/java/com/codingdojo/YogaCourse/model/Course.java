package com.codingdojo.YogaCourse.model;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "courses")
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 @NotEmpty(message="Username is required!")
	 @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	 private String userName;
	 @NotEmpty(message="Day is required!")
	 @Size(min=3, max=128, message="day must be between 3 and 128 characters")
	 private String day;
	 @Min(1)
	 private double price;
	 @NotEmpty(message="description is required!")
	 @Size(min=3, max=300, message="description must be between 3 and 30 characters")
	 private String description;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user")
	 private User user;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Course() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
