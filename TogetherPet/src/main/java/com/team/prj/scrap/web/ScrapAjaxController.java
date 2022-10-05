package com.team.prj.scrap.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.prj.scrap.service.ScrapService;
import com.team.prj.scrap.service.ScrapVO;

//20221005 소현 스크랩 기능을 위해 클래스 추가함 
public class ScrapAjaxController {

	//유저가 하트 누르면 스크랩
	
	@Autowired
	
	private ScrapService service;
	
	// 스크랩 확인 여부 용 데이터 가져오기 (리스트 GetMapping)
	
	@GetMapping("/ajaxScrapCount.do")
	@ResponseBody
	
	public int scrapCount(ScrapVO vo) {
		return service.scrapCount(vo);
	}
	
	//스크랩기능등록(등록PostMapping)
	@PostMapping("/ajaxScrapInsert.do")
	@ResponseBody
	public int scrapInsert(ScrapVO vo) {
		return service.scrapInsert(vo);
		
	}
	
	//스크랩 기능삭제(삭제 GetMapping)
	
	@GetMapping("ajaxScrapDelete.do")
	@ResponseBody
	public int scrapDelete(ScrapVO vo) {
		return service.scrapDelete(vo);
	}
	
}
