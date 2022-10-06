package com.team.prj.hospital.web;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.hospital.service.HospitalService;
import com.team.prj.hospital.service.HospitalVO;
import com.team.prj.scrap.service.ScrapService;
import com.team.prj.scrap.service.ScrapVO;
import com.team.prj.users.service.UsersService;


//@controller + @responseBody 합쳐진것 호출한페이지로 결과를돌려준다.
@RestController


	public class HospitalAjaxController {
	 @Autowired
	 private HospitalService ajaxdao;
	 
	 @Autowired 
	 private ScrapService Service;
	 
	 @Autowired
	 private UsersService Uservice;
	 
	 @RequestMapping("/hospitalajaxSearch")
	 @ResponseBody
	 public List<HospitalVO> ajaxSearch(String key, @RequestParam String val){
		return ajaxdao.hospitalSearch(key, val);
	 }
	 
	 
	 //소현 스크랩추가 20221006
	 
	 @PostMapping(value = "/scrapInsert.do")
	 @ResponseBody
	 
	 public int scrapInsert(ScrapVO vo) {
		 
		 return Service.scrapInsert(vo);
		 
	 }
	 
	 
}
