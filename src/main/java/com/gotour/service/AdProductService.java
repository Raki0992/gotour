package com.gotour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;

@Service
public interface AdProductService {
	
	void pro_insert(ProductVO vo);

	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
}
