package com.gotour.mapper;

import java.util.List;

import com.gotour.domain.CategoryVO;

public interface AdminCategoryMapper {

	List<CategoryVO> getFirstCategoryList();
	
	List<CategoryVO> secondCategoryList(Integer cg_parent_code);
	
	
}
