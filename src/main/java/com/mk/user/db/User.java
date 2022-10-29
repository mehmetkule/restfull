package com.mk.user.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user_account")
public class User {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id",columnDefinition = "uuid",unique = true)
	private UUID id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "password",length = 60)
	private String password;

	@Column(name = "secret")
	private String secret;

	@Column(name = "token")
	private String token;

	@CreationTimestamp
	@Column(name = "created_at",columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt =  Date.from(Instant.now());

	@CreationTimestamp
	@Column(name = "updated_at",columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt =  Date.from(Instant.now());

	public User() {
	}

	public User(String fistName, String lastName, String email, String password) {
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User(String fistName, String lastName, String email, String password, String secret, String token, Date createdAt, Date updatedAt) {
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.secret = secret;
		this.token = token;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
}
