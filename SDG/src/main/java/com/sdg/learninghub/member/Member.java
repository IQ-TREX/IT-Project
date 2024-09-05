package com.sdg.learninghub.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
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
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MemberRole role;
	
	@Enumerated(EnumType.STRING)
	private Provider provider;
	
	private String providerId;
}