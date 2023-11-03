package com.gotour.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gotour.domain.CategoryVO;
import com.gotour.service.AdminCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
@ControllerAdvice(basePackages = {"com.gotour.controller"})
public class GlobalControllerAdvice {
	
	private final AdminCategoryService adminCategoryService;
	
	@ModelAttribute
	public void getFirstCategoryList(Model model) {
		log.info("1차카테고리 리스트");
		
		List<CategoryVO> firstCategoryList = adminCategoryService.getFirstCategoryList();
		model.addAttribute("firstCategoryList", firstCategoryList);
	}

	
}
