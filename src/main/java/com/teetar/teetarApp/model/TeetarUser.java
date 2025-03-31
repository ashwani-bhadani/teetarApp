package com.teetar.teetarApp.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
@Table(name="teetar_user")
public class TeetarUser {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id", unique=true, nullable = false)
	private String emailId;
	
	@Column(name="phone_num", unique=true, nullable = false)
	private String phoneNum;
	
	@Column(name="date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE) //TODO: check if you want to use springframework.datajpa.repository or jakarta?
	private LocalDate dateOfBirth;
	
	@Column(name="username", nullable = false)
	private String username; 
	//TODO: add username generator(a logic that will add position & ascii code of character to
	//find a number to see if this username is already taken or not)
	
	@JsonIgnore
	@Transient
	private String[] password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
				name = "user_role_junction",
				joinColumns = {@JoinColumn(name="user_id")},
				inverseJoinColumns = {@JoinColumn(name="role_id")}
			)
	private Set<Role> authorities;
	
	public TeetarUser() {
		this.authorities = new HashSet<>(); //set authorities to here to not check for empty every time
	}
	
	//TODO: see if you need custom hashCode & equals
	//getters & setters below
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate localDate) {
		this.dateOfBirth = localDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String[] getPassword() {
		return password;
	}

	public void setPassword(String[] password) {
		this.password = password;
	}

	public Set<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

}
