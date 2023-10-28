package com.gotour.service;

import com.gotour.domain.MemberVO;

public interface MemberService {
	
	String idCheck(String mbsp_id); 
	
	void join(MemberVO vo);
	
	MemberVO login(String mbsp_id);
}
