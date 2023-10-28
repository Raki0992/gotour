package com.gotour.mapper;

import com.gotour.domain.MemberVO;

public interface MemberMapper {
	
	String idCheck(String mbsp_id);
	
	void join(MemberVO vo);
	
	MemberVO login(String mbsp_id);
}
