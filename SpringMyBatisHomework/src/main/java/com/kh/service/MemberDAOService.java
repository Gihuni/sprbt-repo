package com.kh.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.domain.MemberEmail;

public interface MemberDAOService {
	// 회원 삽입
	public void insert(Member member) throws Exception;

	// 회원 권한 삽입
	public void insertAuth(MemberAuth memberAuth) throws Exception;
	public void insertEmail(MemberEmail memberEmail) throws Exception;

	// 회원 정보 출력
	public List<Member> selectAll() throws Exception;

	// 회원 정보 출력(회원, 권한 조인)
	public Member selectJoin(Member member) throws Exception;

	// 회원 정보 수정
	public void update(Member member) throws Exception;

	// 회원 정보 삭제
	public void delete(Member member) throws Exception;

	// 회원 권한 정보 삭제
	public void deleteAuth(Member member) throws Exception;
	public void deleteEmail(Member member) throws Exception;

}
