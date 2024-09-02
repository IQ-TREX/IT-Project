package com.sdg.learninghub.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @return user
	 */
	public SiteUser create(String username, String email, String password, String firstName, String lastName) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		this.userRepository.save(user);
		return user;
	}
}
