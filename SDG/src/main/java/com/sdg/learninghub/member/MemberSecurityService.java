/**package com.sdg.learninghub.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws
UsernameNotFoundException {
		Optional<Member> user = this.memberRepository.findByEmail(email);
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("User does not exist.");
		}
		Member member = user.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
	}
}*/


