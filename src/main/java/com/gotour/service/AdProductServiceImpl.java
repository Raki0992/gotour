package com.gotour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;
import com.gotour.dto.ProductDTO;
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

	@Override
	public List<ProductVO> pro_list(Criteria cri) {
		return adProductMapper.pro_list(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return adProductMapper.getTotalCount(cri);
	}

	@Override
	public void pro_checked_modify1(List<Integer> pro_num_arr, List<Integer> pro_price_arr, List<String> pro_buy_arr) {
		
		for(int i=0; i<pro_num_arr.size(); i++) {
			adProductMapper.pro_checked_modify1(pro_num_arr.get(i), pro_price_arr.get(i), pro_buy_arr.get(i));
		}
	}

	@Override
	public void pro_checked_modify2(List<Integer> pro_num_arr, List<Integer> pro_price_arr, List<String> pro_buy_arr) {
		List<ProductDTO> pro_modify_list = new ArrayList<ProductDTO>();
		
		for(int i=0; i<pro_num_arr.size(); i++) {
			ProductDTO productDTO = new ProductDTO(pro_num_arr.get(i), pro_price_arr.get(i), pro_buy_arr.get(i));
			pro_modify_list.add(productDTO);
		}
		
		adProductMapper.pro_checked_modify2(pro_modify_list); 
	}

	@Override
	public ProductVO pro_edit(Integer pro_num) {
		return adProductMapper.pro_edit(pro_num);
	}
	
	
	
	
	
	
	
	
	
}
