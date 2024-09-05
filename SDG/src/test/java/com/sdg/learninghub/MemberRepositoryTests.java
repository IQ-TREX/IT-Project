package com.sdg.learninghub;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sdg.learninghub.member.Member;
import com.sdg.learninghub.member.MemberRepository;
import com.sdg.learninghub.member.MemberRole;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MemberRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	@DisplayName("Test 1: Store member data in repository.")
	public void testCreateMember() {
		Member member = new Member();
		member.setEmail("test@gmail.com");
		member.setPassword("1234");
		member.setFirstName("test");
		member.setLastName("test");
		member.setUsername("test");
		member.setRole(MemberRole.USER);
		
		Member savedMember = memberRepository.save(member);
		Member existMember = entityManager.find(Member.class, savedMember.getId());	     
		assertThat(member.getEmail()).isEqualTo(existMember.getEmail());
		assertThat(member.getPassword()).isEqualTo(existMember.getPassword());
	}
}
