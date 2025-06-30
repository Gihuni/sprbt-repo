package com.kh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kh.domain.MybatisBoard;


public interface BoardDAO {

//게시판 삽입
	public void insert(MybatisBoard board) throws Exception;

//게시판 출력(one)
	public MybatisBoard select(MybatisBoard board) throws Exception;

//게시판 수정
	public void update(MybatisBoard board) throws Exception;

//게시판 삭제
	public void delete(MybatisBoard board) throws Exception;

//게시판 출력(전체)
	public List<MybatisBoard> selectAll() throws Exception;
}
