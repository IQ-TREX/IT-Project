package com.sdg.learninghub.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @return member
	 */
	public Member create(String username, String email, String password, String firstName, String lastName) {
		Member member = new Member();
		member.setUsername(username);
		member.setEmail(email);
		member.setPassword(passwordEncoder.encode(password));
		member.setFirstName(firstName);
		member.setLastName(lastName);
		this.memberRepository.save(member);
		return member;
	}
}
