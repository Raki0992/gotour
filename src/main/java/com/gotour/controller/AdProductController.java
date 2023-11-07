package com.gotour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gotour.domain.ProductVO;
import com.gotour.dto.Criteria;
import com.gotour.dto.PageDTO;
import com.gotour.service.AdProductService;
import com.gotour.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin/product/*")
@Controller
public class AdProductController {

	private final AdProductService adProductService;
	
	// 업로드 폴더경로 주입
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	// CKEditor에서 사용되는 업로드 폴더경로
	@Resource(name = "uploadCKPath")
	private String uploadCKPath;
	
	@GetMapping("/pro_insert")
	public void pro_insert() {
		log.info("상품등록 폼");
	}
	
	@PostMapping("/pro_insert")
	public String pro_insert(ProductVO vo, MultipartFile uploadFile, RedirectAttributes rttr) {
		log.info("상품정보 :" + vo);
		
		// 1) 파일업로드 작업 (FileUtils)
		String dateFolder = FileUtils.getDateFolder();
		String savedFileName = FileUtils.uploadFile(uploadPath, dateFolder, uploadFile);
		
		vo.setPro_img(savedFileName);
		vo.setPro_up_folder(dateFolder);
		
		// 2) 상품정보 저장
		adProductService.pro_insert(vo);
		
		
		return "redirect:/admin/product/pro_list";
	}
	
	@PostMapping("/imageUpload")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String ckUploadPath = uploadCKPath + fileName;
			
			log.info("CKEditor파일경로 : " + ckUploadPath);
			
			out = new FileOutputStream(new File(ckUploadPath));
			
			out.write(bytes);
			out.flush();
			
			printWriter = response.getWriter();
			
			String fileUrl = "/ckupload/" + fileName;
			printWriter.println("{\"filename\":\"" +  fileName + "\", \"uploaded\":1,\"url\":\"" + fileUrl + "\"}");
	        printWriter.flush();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if(printWriter != null) printWriter.close();
		}
	}
	
	@GetMapping("/pro_list")
	public void pro_list(Criteria cri, Model model) throws Exception {
		
		cri.setAmount(2);
		
		List<ProductVO> pro_list = adProductService.pro_list(cri);
		
		pro_list.forEach(vo-> {
			vo.setPro_up_folder(vo.getPro_up_folder().replace("\\", "/"));
		});
		
		model.addAttribute("pro_list", pro_list);
		
		int totalCount = adProductService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
	}
	
	@ResponseBody
	@GetMapping("/imageDisplay")
	public ResponseEntity<byte[]> imageDisplay(String dateFolderName, String fileName) throws Exception {
		return FileUtils.getFile(uploadPath + dateFolderName, fileName);
	}
	
	@ResponseBody
	@PostMapping("/pro_checked_modify")
	public ResponseEntity<String> pro_checked_modify(
			@RequestParam("pro_num_arr[]")List<Integer> pro_num_arr,
			@RequestParam("pro_price_arr[]")List<Integer> pro_price_arr,
			@RequestParam("pro_buy_arr[]")List<String> pro_buy_arr 
			) throws Exception {
		ResponseEntity<String> entity = null;
		log.info(pro_num_arr);
		log.info(pro_price_arr);
		log.info(pro_buy_arr);
		
		adProductService.pro_checked_modify1(pro_num_arr, pro_price_arr, pro_buy_arr);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	@GetMapping("/pro_edit")
	public void pro_edit(@ModelAttribute("cri") Criteria cri, Integer pro_num, Model model) throws Exception {
		
		// 선택한 상품정보
		ProductVO productVO = adProductService.pro_edit(pro_num);
		model.addAttribute("ProductVO", adProductService.pro_edit(pro_num));
		
		// 1차 전체카테고리
		
		// 상품카테고리에서 2차카테고리를 이용한 1차카테고리 정보참조 
		model.addAttribute("first_category", adProductService.get(productVO.getCg_code()));
	}
	
}













