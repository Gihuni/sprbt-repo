package com.zeus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;

// 사용자 요청을 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 DB를 연동한다. 결과값을 해당되는 view로 넘겨준다.
@Slf4j
@Controller
@RequestMapping(value = "/board")
public class BoardController {
	// http://~:8080/board/read/100 -> url 마지막 경로(path)의 값을 int boardNo에 입력하고,
	// /board/read.jsp
	// Model 전송하고 출력화면을 전송해주시오.
	@GetMapping("/read/{boardNo}")
	public String getRead(@PathVariable("boardNo") String boardNo, Model model) {
		log.info("게시글 번호 : " + boardNo);
		model.addAttribute("boardNo", boardNo);

		return "/board/read";
	}

	@GetMapping(value = "/form")
	public String form() {
		log.info("board Start");
		return "/board/form";
	}

	@GetMapping(value = "/ajaxHome")
	public String ajaxHome() {
		log.info("headers 속성 매핑   ajaxHome");
		return "/board/ajaxHome";
	}

	@GetMapping(value = "/xmlHttpRequest")
	public String xmlHttpRequest() {
		log.info("headers 속성 매핑   xmlHttpRequest");
		return "/board/xmlHttpRequest";
	}

	@PutMapping(value = "/{boardNo}", consumes = "application/json")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("수정 Board=" + board);
		log.info("수정 BoardNo=" + boardNo);
		// DB 연동 => update => 리턴값 주고 => 리턴값을 ResponseEntity<String> 클라이언트 전송
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	// X-HTTP-Method-Override 요청 헤더 값을 "PUT"으로 지정
	@PutMapping(value = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("수정 Headers Board=" + board);
		log.info("수정 Headers BoardNo=" + boardNo);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping(value = "/{boardNo}", consumes = "application/json")
	public ResponseEntity<String> modifyPost(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("수정 post Board=" + board);
		log.info("수정 post boardNo =" + boardNo);
		// 디비 연동 => 업데이트 => 리턴값주고 => 리턴값을 ResponseEntity<String> 클라이언트 전송
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

}
