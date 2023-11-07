package com.gotour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gotour.domain.CategoryVO;
import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;
import com.gotour.dto.ProductDTO;

@Service
public interface AdProductService {
	
	void pro_insert(ProductVO vo);

	List<ProductVO> pro_list(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	void pro_checked_modify1(List<Integer> pro_num_arr,List<Integer> pro_price_arr, List<String> pro_buy_arr);
	
	void pro_checked_modify2(List<Integer> pro_num_arr,List<Integer> pro_price_arr, List<String> pro_buy_arr);
	
	ProductVO pro_edit(Integer pro_num);
	
	CategoryVO get(Integer cg_code);
}
