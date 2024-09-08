package com.sdg.learninghub.member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class MemberController {
	
	private final MemberService memberService;

	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getField() + ": " + error.getDefaultMessage());
            }
			return "signup_form";
		}
		
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "password.mismatch", "Those passwords didn’t match. Try again.");
			return "signup_form";
		}
		
		try {
			memberService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), 
					userCreateForm.getPassword1(), userCreateForm.getFirstName(), userCreateForm.getLastName());
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.rejectValue("email", "email.duplicate", "An account with this email already exists.");
			return "signup_form";
		}catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("signup.error", e.getMessage());
		}
		
		//terms.accept
		return "login_success";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login_success")
	public String login_success() {
		return "login_success";
	}
	
	@GetMapping("/access_denied")
	public String access_denied() {
		return "access_denied";
	}
}

