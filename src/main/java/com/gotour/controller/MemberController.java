package com.gotour.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gotour.domain.MemberVO;
import com.gotour.dto.LoginDTO;
import com.gotour.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/join")
	public void join() {
		log.info("join 테스트");
	}
	
	@GetMapping("/idCheck")
	public ResponseEntity<String> idCheck(String mbsp_id) {
		log.info("아이디 : " + mbsp_id); 
		
		ResponseEntity<String> entity = null;
		
		String idUse = "";
		if(memberService.idCheck(mbsp_id) != null) {
			idUse = "no";
		}else {
			idUse = "yes";
		}
		
		entity = new ResponseEntity<String>(idUse, HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/join")
	public String join(MemberVO vo, RedirectAttributes rttr) {
		log.info("회원정보 : " + vo);
		
		vo.setMbsp_password(passwordEncoder.encode(vo.getMbsp_password()));
		
		log.info("암호화비밀번호 : " + vo.getMbsp_password());
		
		memberService.join(vo);
		return "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public String login(LoginDTO dto, RedirectAttributes rttr, HttpSession session) {
		
		log.info("로그인 : " + dto);
		
		MemberVO vo = memberService.login(dto.getMbsp_id());
		
		String url = "";
		String msg = "";
		
		if(vo != null) {
			if(passwordEncoder.matches(dto.getMbsp_password(), vo.getMbsp_password()))	{
				// 로그인 성공결과로 서버측의 메모리를 사용하는 세션형태작업
				session.setAttribute("loginStatus", vo);
				rttr.addFlashAttribute("msg", msg);
				url = "/";	
		}else {
			url = "/member/login";	
			msg = "비밀번호가 일치하지 않습니다."; 
			rttr.addFlashAttribute("msg", msg); 
		}
	}else {
		url = "/member/login";	
		msg = "아이디가 존재하지 않습니다.";
		rttr.addFlashAttribute("msg", msg);	
	}
		return "redirect:" + url;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	}







