package com.team.prj.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.hospital.service.HospitalService;
import com.team.prj.hospital.service.HospitalVO;


//@controller + @responseBody 합쳐진것 호출한페이지로 결과를돌려준다.
@RestController


public class HospitalAjaxController {
	 @Autowired
	 private HospitalService ajaxdao;
	 
	 @RequestMapping("/hospitalajaxSearch")
	 @ResponseBody
	 public List<HospitalVO> ajaxSearch(String key, @RequestParam String val){
		return ajaxdao.hospitalSearch(key, val);
		 
		 
	 }
}
