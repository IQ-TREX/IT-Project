package com.sdg.learninghub.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 45)
	private String username;
	
	@Column(length = 40)
	private String password;
	
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 45)
	private String firstName;
	
	@Column(nullable = false, length = 45)
	private String lastName;
	
}