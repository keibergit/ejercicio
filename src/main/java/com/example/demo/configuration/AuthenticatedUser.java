package com.example.demo.configuration;

import java.util.Date;

public class AuthenticatedUser {
	

	public AuthenticatedUser(String mensaje,long id, String token, Date createdAt, Date lastLogin, Date updatedAt, boolean isactive) {
		super();
		this.mensaje = mensaje;
		this.id = id;
		this.token = token;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
		this.updatedAt = updatedAt;
		this.isactive = isactive;
	}
	
	private long id;
	private String token;
	private Date createdAt;
	private Date lastLogin;
	private Date updatedAt;
	private boolean isactive; 
	private String mensaje;
	



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}