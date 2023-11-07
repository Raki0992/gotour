package com.gotour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gotour.domain.CategoryVO;
import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;
import com.gotour.dto.ProductDTO;

public interface AdProductMapper {

	void pro_insert(ProductVO vo);
	
	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	void pro_checked_modify1(
			@Param("pro_num") Integer pro_num,
			@Param("pro_price") Integer pro_price,
			@Param("pro_buy") String pro_buy
			);
	
	void pro_checked_modify2(List<ProductDTO> pro_modify_list);
	
	ProductVO pro_edit(Integer pro_num);
	
	CategoryVO get(Integer cg_code);
}
