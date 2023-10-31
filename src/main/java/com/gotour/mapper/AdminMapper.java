package com.gotour.mapper;

import com.gotour.domain.AdminVO;

public interface AdminMapper {

	AdminVO admin_ok(String admin_id);
	
	void loginTimeUpdate(String admin_id);
}
