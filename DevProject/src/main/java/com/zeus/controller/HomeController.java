package com.zeus.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;

//사용자정보를 받고 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 db 연동한다. 뷰를 불러준다.
@Slf4j
@Controller
public class HomeController {

	// http://127.0.0.1:8080/home get방식
	// Model,(Request, Session, Application)
	@GetMapping(value = "/home")
	public String home(Locale locale, Model model) {
		log.info("여기는 HomeController home() 입니다." + locale.toString());
		log.info("여기는 HomeController home() 입니다." + model.toString());
		// db연동하지 않는다.
		// 뷰를 불러준다.(~ : view Resolver)
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formatDate = df.format(date);
		// 모델(Request)
		model.addAttribute("serverTime", formatDate);
		return "home01";
	}

	@GetMapping(value = "/sub")
	public String boardPrint(Model model) {
		Board board = new Board(10, "kdj", "zeus", "김동진", new Date());
		model.addAttribute(board);
		return "home02";
	}

	@GetMapping(value = "/home03")
	public String home03() {
		return "home03";
	}

	@GetMapping(value = "/home04")
	public String home04(Locale locale, Model model) {
		// 문자열 배열, ArrayList => VO,DB
		String[] name = { "홍길동", "제우스", "톰캣" };
		List<String> nameList = Arrays.asList("홍길동", "제우스", "톰캣");
		model.addAttribute("name", name);
		model.addAttribute("nameList", nameList);
		return "home04";
	}

	@GetMapping(value = "/home05")
	public String home05(Model model) {
		// HashMap 만들어서 (DB, 사용자입력) 화면으로 보냄. id, pwd, email, name, date
		Map mMap = new HashMap<>();
		mMap.put("id", "rlaeogus");
		mMap.put("pwd", "123456");
		mMap.put("email", "rlaeogus@nate.com");
		mMap.put("name", "kdj");
		mMap.put("date", new Date());
		model.addAttribute("mMap", mMap);
		return "home05";
	}

	@GetMapping("/home0303")
	public String home0303(Model model) {
		Board board = new Board();
		board.setTitle("");
		model.addAttribute("board",board);
		return "home0303";
	}
	
	@GetMapping("/home0202")
	public String home0202(Model model) {
		Board board = new Board();
		board.setTitle("spring boot");
		model.addAttribute("board",board);
		return "home0202";
	}
	
	//WEB-INF/view/home0901.jsp, get
	@GetMapping("/home0901")
	public String home0901() {
		return "home0901";
	}
	//WEB-INF/view/boardjstl/search.jsp, get, parameter value, model 전달해서 화면에 출력해보기
	@RequestMapping("/boardjstl/search")
	public void search1(Board board, int title, Model model) {
		log.info("search keyword = " + board);
		log.info("search keyword title = " + (title+100));
		model.addAttribute("board", board);
	}
	
	@RequestMapping("/boardjstl/list")
	public void list() {
		log.info("/boardjstl/list");
	}
	
	@RequestMapping("/home1001")
	public void home1001() {
		log.info("/home1001");
	}
}
