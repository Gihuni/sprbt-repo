package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.domain.MemberEmail;
import com.kh.mapper.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberDAOServiceImpl implements MemberDAOService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	@Transactional
	// 회원 입력처리, 회원 권한 입력처리
	public void insert(Member member) throws Exception {
		// 회원 등록 처리
		memberDAO.insert(member);
		// 회원 권한 객체 생성
		MemberAuth memberAuth = new MemberAuth();
		
		// 회원 권한 설정
		memberAuth.setNo(member.getNo());
		memberAuth.setAuth("ROLE_USER");
		
		
		// 회원 권한 처리
		memberDAO.insertAuth(memberAuth);
	
	}

	@Override
	@Transactional
	// 회원권한 입력처리
	public void insertAuth(MemberAuth memberAuth) throws Exception {
		memberDAO.insertAuth(memberAuth);
	}

	@Override
	@Transactional
	public void insertEmail(MemberEmail memberEmail) throws Exception {
		memberDAO.insertEmail(memberEmail);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return memberDAO.selectAll();
	}

	@Override
	public Member selectJoin(Member member) throws Exception {
		return memberDAO.selectJoin(member);
	}

	@Override
	@Transactional
	// 회원정보 수정
	public void update(Member member) throws Exception {
		// 회원정보 수정입력
		memberDAO.update(member);
		// 회원권한 삭제
		memberDAO.deleteAuth(member);
		memberDAO.deleteEmail(member);

		// 수정된 회원권한 입력
		List<MemberAuth> authList = member.getAuthList();
		for (int i = 0; i < authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if (auth == null) {
				continue;
			}
			if (auth.trim().length() == 0) {
				continue;
			}
			memberAuth.setNo(member.getNo());
			memberDAO.insertAuth(memberAuth);
		}
		List<MemberEmail> emailList = member.getEmailList();
		for (int i = 0; i < emailList.size(); i++) {
			MemberEmail memberEmail = emailList.get(i);
			String email = memberEmail.getEmail();
			if (email == null) {
				continue;
			}
			if (email.trim().length() == 0) {
				continue;
			}
			memberEmail.setNo(member.getNo());
			memberDAO.insertEmail(memberEmail);
		}

	}

	@Override
	@Transactional
	public void delete(Member member) throws Exception {
		log.info("MemberDAOServiceImpl delete start");
		memberDAO.deleteAuth(member); // 삭제 순서
		log.info("MemberDAOServiceImpl deleteAuth end");
		memberDAO.deleteEmail(member); // 삭제 순서
		log.info("MemberDAOServiceImpl deleteEmail end");
		memberDAO.delete(member);
		log.info("MemberDAOServiceImpl delete end");
	}

	@Override
	@Transactional
	public void deleteAuth(Member member) throws Exception {
		memberDAO.deleteAuth(member);

	}

	@Override
	@Transactional
	public void deleteEmail(Member member) throws Exception {
		memberDAO.deleteEmail(member);

	}

}
