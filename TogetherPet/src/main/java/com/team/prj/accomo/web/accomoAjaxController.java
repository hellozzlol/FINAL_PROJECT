package com.team.prj.accomo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.accomo.service.accomoService;
import com.team.prj.accomo.service.accomoVO;
import com.team.prj.hospital.service.HospitalService;
import com.team.prj.scrap.service.ScrapService;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.users.service.UsersService;

//@controller + @responseBody 합쳐진것 호출한페이지로 결과를돌려준다.
@RestController
public class accomoAjaxController {

	@Autowired
	private accomoService ajaxdao;
	
	@Autowired
	private ScrapService Sservice;
	
	@Autowired 
	private UsersService Uservice;
	
	@Autowired
	
	private HospitalService Hservice;
	
	@RequestMapping("/accomoajaxSearch")	
	public List<accomoVO> ajaxSearch(String key, @RequestParam String val){

		List<accomoVO> list = ajaxdao.accomoSearch(key, val);

		return list;
	}
	
	//소현 스크랩추가 20221006
	 
		 @PostMapping(value = "/ScrapInsert.do")
		 @ResponseBody
		 
		 public int scrapInsert(ScrapVO vo) {
			 
			 return Hservice.scrapInsert(vo);
			 
		 }
	
	
	
}
