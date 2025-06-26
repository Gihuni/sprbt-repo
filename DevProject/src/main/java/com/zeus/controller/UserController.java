package com.zeus.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

// 사용자 정보를 받는다 -> 해당되는 DB를 연동한다. -> 결과값을 해당되는 view로 넘겨준다.
@Slf4j
@Controller
@RequestMapping(value = "member", method = RequestMethod.GET)
public class UserController {
	@GetMapping(value = "/registerForm")
	public String registerForm() {
		log.info("registerForm");
		return "member/registerForm";
	}

	@PostMapping(value = "/register")
	public String register(Member member) {
		log.info("register");
		log.info("member = " + member);
		log.info("member_Date = " + member.getDateOfBirth());
		return "member/success";
	}
	@GetMapping(value="/radiobuttons01")
	public String registerSpringFormRadiobuttons01(Model model) {
		log.info("Radiobuttons01");
		Map<String, String> genderColdeMap = new HashMap<String, String>();
		genderColdeMap.put("01", "Male");
		genderColdeMap.put("02", "Female");
		genderColdeMap.put("03", "Other");
		model.addAttribute("genderCodeMap", genderColdeMap);
		model.addAttribute("member", new Member());
		return "user/radiobuttons01"; // 뷰 파일명
	}

}
