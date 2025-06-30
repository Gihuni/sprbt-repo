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

@Service
public interface MemberDAOService {

//게시판 삽입
	public void insert(Member member) throws Exception;

//게시판 출력(one)
	public Member select(Member member) throws Exception;

//게시판 수정
	public void update(Member member) throws Exception;

//게시판 삭제
	public void delete(Member member) throws Exception;

//게시판 출력(전체)
	public List<Member> selectAll() throws Exception;
}
