package com.kh.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.SpringJdbcMemberApplication;
import com.kh.domain.Member;
@Repository
public class MemberDAO {
	private final SpringJdbcMemberApplication springJdbcMemberApplication;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String insertMember = "INSERT INTO Member(member_no, member_id, member_pwd, member_name) VALUES(Member_seq.NEXTVAL, ?, ?, ?)";
	private String selectByNoMember = "SELECT member_no, member_id, member_pwd, member_name FROM Member WHERE member_no = ?";
	private String updateMember = "UPDATE Member SET member_id =?, member_pwd =?, member_name =? WHERE member_no = ?";
	private String deleteMember = "DELETE from Member where member_no = ?";
	private String selectMember = "SELECT member_no, member_id, member_pwd, member_name FROM Member WHERE member_no > 0 ORDER BY member_no desc";

	MemberDAO(SpringJdbcMemberApplication springJdbcMemberApplication) {
		this.springJdbcMemberApplication = springJdbcMemberApplication;
	}

//게시판 삽입
	public void insert(Member member) throws Exception {
		jdbcTemplate.update(insertMember, member.getId(), member.getPwd(), member.getName());
	}

//게시판 출력(one)
	public Member select(Member member) throws Exception {
		List<Member> results = jdbcTemplate.query(selectByNoMember, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setNo(rs.getInt("member_no"));
				member.setId(rs.getString("member_id"));
				member.setPwd(rs.getString("member_pwd"));
				member.setName(rs.getString("member_name"));
				return member;
			}
		}, member.getNo());

		return results.isEmpty() ? null : results.get(0);
	}

//수정
	public void update(Member member) throws Exception {
		jdbcTemplate.update(updateMember, member.getId(), member.getPwd(), member.getName(), member.getNo());
	}

//삭제
	public void delete(Member member) throws Exception {
		jdbcTemplate.update(deleteMember, member.getNo());
	}

//출력(전체)
	public List<Member> selectAll() throws Exception {
		List<Member> results = jdbcTemplate.query(selectMember, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setNo(rs.getInt("member_no"));
				member.setId(rs.getString("member_id"));
				member.setPwd(rs.getString("member_pwd"));
				member.setName(rs.getString("member_name"));
				return member;
			}
		});
		return results;
	}
}
