package com.gotour.service;

import java.util.List;

import com.gotour.domain.CategoryVO;

public interface AdminCategoryService {

	List<CategoryVO> getFirstCategoryList();
	
	List<CategoryVO> getsecondCategoryList(Integer cg_parent_code);
}
