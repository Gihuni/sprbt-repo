package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.Member;
import com.kh.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	@Autowired
	private MemberDAO mDAO;

	@Override
	public void insert(Member member) throws Exception {
		mDAO.insert(member);
	}

	@Override
	public Member select(Member member) throws Exception {
		return mDAO.select(member);
	}

	@Override
	public void update(Member member) throws Exception {
		mDAO.update(member);
	}

	@Override
	public void delete(Member member) throws Exception {
		mDAO.delete(member);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return mDAO.selectAll();
	}

}
