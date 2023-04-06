//Create a model called Burger...

package com.codingdojo.burgertracker1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//...add annotations...

@Entity
@Table(name="burgers")
public class Burger {
	
//	...with all appropriate fields.	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@NotNull
	@Size(min = 5, max = 200, message="Burger name must be at least five characters long.")
	private String name;
	@NotNull
	@Size(min = 5, max = 200, message="Restaurant name must be at least five characters long.")
	private String restaurantName;
	@NotNull(message="Must give a rating of at least one.")
	@Min(value = 1, message="Must give a rating of at least one.")
	@Max(value = 5, message="The highest rating is five.")
	private Integer rating;
	@NotNull
	@Size(max = 200)
	private String notes;
	
	public Burger() {
	}
	public Burger(String name, String restaurantName, Integer rating, String notes) {
		this.name = name;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}
	
//	...add getters & setters!
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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

