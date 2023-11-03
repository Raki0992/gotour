package com.gotour.service;

import org.springframework.stereotype.Service;

import com.gotour.domain.ProductVO;
import com.gotour.mapper.AdProductMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdProductServiceImpl implements AdProductService {

	private final AdProductMapper adProductMapper;

	@Override
	public void pro_insert(ProductVO vo) {
		adProductMapper.pro_insert(vo);
	}
}
