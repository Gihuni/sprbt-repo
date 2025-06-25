package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.Member;
import com.kh.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired // 자동주입
	private MemberDAO dao;

	@Override
	public void insert(Member member) throws Exception {
		dao.insert(member);
	}

	@Override
	public Member select(Member member) throws Exception {
		return dao.select(member);
	}

	@Override
	public void update(Member member) throws Exception {
		dao.update(member);
	}

	@Override
	public void delete(Member member) throws Exception {
		dao.delete(member);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return dao.selectAll();
	}
}