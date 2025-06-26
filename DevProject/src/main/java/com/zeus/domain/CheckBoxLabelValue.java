package com.zeus.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
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
public class CheckBoxLabelValue {
	// 멤버변수
	private String userId;
	private String password;

}
