package com.libsys.Maurilib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="favoris")
public class Favoris {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String livreId;
	private String userId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLivreId() {
		return livreId;
	}
	public void setLivreId(String livreId) {
		this.livreId = livreId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
