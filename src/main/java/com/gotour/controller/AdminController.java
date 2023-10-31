package com.gotour.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gotour.domain.AdminVO;
import com.gotour.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin/*")
@Controller
public class AdminController {

	private final AdminService adminService;
	
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String adminLogin() {
		log.info("관리자 로그인 페이지");
		
		return "/admin/adLogin";
	}
	
	@PostMapping("/admin_ok")
	public String admin_ok(AdminVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		log.info("관리자 로그인 : " + vo);
		
		AdminVO db_vo = adminService.admin_ok(vo.getAdmin_id());
		
		String url = "";
		String msg = "";
		
		if(db_vo != null) {
			if(passwordEncoder.matches(vo.getAdmin_pw(), db_vo.getAdmin_pw())) {
				session.setAttribute("adminStatus", db_vo);
				
				// 로그인 시간 업데이트
				
				url = "/admin/admin_menu";  // 관리자 메뉴페이지 주소
			}else {
				url = "/admin/intro";
				msg = "failPW";
				rttr.addFlashAttribute("msg", msg); // 로그인 폼 jsp파일에서 사용
			}
		}else {
			url = "/admin/intro";
			msg = "failID";
			rttr.addFlashAttribute("msg", msg);
		}
		
		return "redirect:" + url;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		log.info("로그아웃");
		return "redirect:/admin/intro";
	}
	
	
	@GetMapping("/admin_menu")
	public void admin_menu() {
		log.info("관리자 메뉴 페이지");
	}
}
