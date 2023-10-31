package com.gotour.service;

import org.springframework.stereotype.Service;

import com.gotour.domain.AdminVO;
import com.gotour.mapper.AdminMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
	
	private final AdminMapper adminMapper;

	@Override
	public AdminVO admin_ok(String admin_id) {
		return adminMapper.admin_ok(admin_id);
	}

	@Override
	public void loginTimeUpdate(String admin_id) {
		adminMapper.loginTimeUpdate(admin_id);
	}
}
