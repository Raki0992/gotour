package com.gotour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;
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
}
