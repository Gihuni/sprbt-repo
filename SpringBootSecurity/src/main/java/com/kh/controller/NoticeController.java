package com.kh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log
@RequestMapping("/notice")
@Controller
public class NoticeController {
	@GetMapping("/list")
	public String list() {
		log.info("list : 모두가 접근 가능");
		return "notice/list";
	}

	@GetMapping("/register")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerForm() {
		log.info("registerForm : 로그인한 회원만 접근 가능");
		return "notice/register";
	}
}