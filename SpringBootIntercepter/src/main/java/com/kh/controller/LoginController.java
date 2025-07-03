package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kh.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@GetMapping("/login")
	// 1. 사용자 요청정보 받는다.
	public String loginForm() {
		
		log.info("2번 LoginController loginForm start");
		// 2. DB연동(mapper 인터페이스 사용한다. 다형성구현)
		// 3. DB연동 리턴값을 화면전달(view resolver, redirect, forward, responseBody:json 총 4가지
		// 전달 방식)
		
		return "login/loginForm";
	}

	@PostMapping("/login")
	public void login(Member member, Model model) {
		log.info("2번 LoginController login start");
		log.info("login userId = " + member.getUserId());
		log.info("login userPw = " + member.getUserPw());

		member.setUserName("제우스");
		member.setEmail("zeus@zeus.com");
		model.addAttribute("user", member);
	}

}
