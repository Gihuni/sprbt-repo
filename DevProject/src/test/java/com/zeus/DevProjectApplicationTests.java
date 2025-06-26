package com.zeus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zeus.domain.Board;

@SpringBootApplication
class DevProjectApplicationTests {

	@Test
	void contextLoads() {
		Board board = new Board();
		System.out.println(board.toString());
	}

}
