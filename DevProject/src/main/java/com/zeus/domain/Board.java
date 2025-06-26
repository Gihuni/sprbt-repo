package com.zeus.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//lombok annotation
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board {
	// 멤버변수
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;

}
