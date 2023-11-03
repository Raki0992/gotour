package com.gotour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gotour.domain.CategoryVO;
import com.gotour.mapper.AdminCategoryMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class AdminCategoryServiceImpl implements AdminCategoryService {

	private final AdminCategoryMapper adminCategoryMapper;

	@Override
	public List<CategoryVO> getFirstCategoryList() {
		return adminCategoryMapper.getFirstCategoryList();
	}

	@Override
	public List<CategoryVO> getsecondCategoryList(Integer cg_parent_code) {
		return adminCategoryMapper.secondCategoryList(cg_parent_code);
	}
}
