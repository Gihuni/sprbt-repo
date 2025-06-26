package com.zeus.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
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
public class MemberController {
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
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

	@PostMapping(value = "/registerSelect")
	public String registerSelect(Member member) {
		log.info("registerSelect");
		for (int i = 0; i < member.getNationality().size(); i++) {
			log.info("nationality member =" + member.getNationality().get(i));
		}
		return "member/success";
	}

	@PostMapping(value = "/registerBoard")
	public String registerBoard(Member member) {
		log.info("register");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		log.info("member.getBoard().getBoardNo() = " + member.getBoard().getBoardNo());

		return "member/success";
	}

	@PostMapping(value = "/registerFileUpload")
	public String registerFileUpload(MultipartFile[] picture) throws IllegalStateException, IOException {
		log.info("registerFileUpload");
		for (MultipartFile data : picture) {
			log.info("serverUseName: " + data.getName());
			log.info("originalName: " + data.getOriginalFilename());
			log.info("size: " + data.getSize());
			log.info("contentType: " + data.getContentType());
			data.transferTo(new File("/Users/iseungmin/springBootServerUploadFile/" + data.getOriginalFilename()));
		}

		return "member/success";
	}

	@RequestMapping(value = "/registerAjaxFileUpForm", method = RequestMethod.GET)
	public String registerAjaxFileUpForm() {
		log.info("registerAjaxFileUpForm");
		return "registerAjaxFileUpForm"; // 뷰 파일명
	}

}
