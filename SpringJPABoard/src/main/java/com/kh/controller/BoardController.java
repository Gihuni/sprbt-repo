package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.Board;
import com.kh.service.BoardDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDAOService service;

	// 게시판 입력화면 요청
	@GetMapping(value = "/registerForm")
	public String registerForm(Board board, Model model) throws Exception {
		log.info("registerForm");
		model.addAttribute("board", board);
		return "board/register";
	}

	// 게시판 DB입력 요청
	@PostMapping(value = "/register")
	public String register(Board board, Model model) throws Exception {
		service.insert(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "board/success";
	}

	// 게시판 리스트화면 요청
	@GetMapping(value = "/list")
	public String list(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", service.selectAll());
		return "board/list";
	}

	// 게시판 상세 화면 요청
	@GetMapping(value = "/read")
	public String read(Board board, Model model) throws Exception {
		model.addAttribute("board", service.select(board));
		return "board/read";
	}

	// 게시판 삭제 요청
	@PostMapping(value = "/remove")
	public String remove(Board board, Model model) throws Exception {
		service.delete(board);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "board/success";
	}

	// 게시판 수정 화면 요청
	@GetMapping(value = "/modify")
	public String modifyForm(Board board, Model model) throws Exception {
		model.addAttribute("board", service.select(board));
		return "board/modify";
	}

	// 게시판 수정 요청
	@PostMapping(value = "/modify")
	public String modify(Board board, Model model) throws Exception {
		service.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";
	}
}
