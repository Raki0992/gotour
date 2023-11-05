package com.gotour.mapper;

import java.util.List;

import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;

public interface AdProductMapper {

	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
}
