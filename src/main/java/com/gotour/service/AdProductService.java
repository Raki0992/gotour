package com.gotour.service;

import org.springframework.stereotype.Service;

import com.gotour.domain.ProductVO;

@Service
public interface AdProductService {
	
	void pro_insert(ProductVO vo);

}
