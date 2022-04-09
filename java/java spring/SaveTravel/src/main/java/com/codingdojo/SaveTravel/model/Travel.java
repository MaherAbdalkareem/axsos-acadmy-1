package com.codingdojo.SaveTravel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "travels")
public class Travel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
    @Size(min = 5, max = 100)
	private String expenseName;
	@NotNull
    @Size(min = 5, max = 100)
	private String vendor;
	@NotNull
    @Size(min = 5, max = 100)
	private String description;
	@NotNull
	@Min(1)
	private Integer amount;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    public Travel( String expenseName,String vendor,  String description, Integer amount) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.description = description;
		this.amount = amount;
	}

	public Travel() {
	}

	public Long getId() {
		return id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}