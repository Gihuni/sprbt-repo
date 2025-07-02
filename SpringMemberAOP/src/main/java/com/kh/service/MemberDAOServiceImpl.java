package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.persistence.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	@Autowired
	private MemberRepository md;

	@Override
	@Transactional
	public void insert(Member member) throws Exception {
		md.save(member);
	}

	@Override
	@Transactional(readOnly = true)
	public Member select(Member member) throws Exception {
		return md.getOne(member.getNo());
	}

	@Override
	@Transactional
	public void update(Member member) throws Exception {
		Member memberEntity = md.getOne(member.getNo());
		memberEntity.setId(member.getId());
		memberEntity.setPw(member.getPw());
		memberEntity.setName(member.getName());
	}

	@Override
	@Transactional
	public void delete(Member member) throws Exception {
		md.deleteById(member.getNo());
	}

	@Override
	@Transactional
	public List<Member> selectAll() throws Exception {
		return md.findAll(Sort.by(Direction.DESC, "no"));
	}

}
