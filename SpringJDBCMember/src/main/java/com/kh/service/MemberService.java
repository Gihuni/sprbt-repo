package com.kh.service;

import java.util.List;

import com.kh.domain.Member;

public interface MemberService {

	//게시판 삽입
	void insert(Member member) throws Exception;

	//게시판 출력(one)
	Member select(Member member) throws Exception;

	//게시판 수정
	void update(Member member) throws Exception;

	//게시판 삭제
	void delete(Member member) throws Exception;

	//게시판 출력(전체)
	List<Member> selectAll() throws Exception;

}
