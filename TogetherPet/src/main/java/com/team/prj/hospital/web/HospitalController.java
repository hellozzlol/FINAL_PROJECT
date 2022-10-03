package com.team.prj.hospital.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.team.prj.hospital.service.HospitalService;
import com.team.prj.hospital.service.HospitalVO;

@Controller
public class HospitalController {

	@Autowired
	private HospitalService dao;

	// 개인 회원 => 병원 스크랩 리스트
	@GetMapping("/usersHospitalList")
	public String hospitalSelectList(HospitalVO vo, Model model, String key) {
		model.addAttribute("hospitalList", dao.hospitalSelectList(key));
		return "users/usersHospitalList";
	}

	// 병원리스트
	
	  @RequestMapping("/hospitalList") 
	  public String hospitalList(Model model, String key){
		  if(key==null) {
			  key="1";
		  }
	 model.addAttribute("hospital",
	 dao.hospitalSelectList(key)); 
	 return "hospital/hospitalList"; 
	  }
	// 상세보기
	@RequestMapping("/hospital")
	public String hospitalSelect(HospitalVO vo, Model model) {
		model.addAttribute("hospital", dao.hospitalSelect(vo));
		dao.hospitalHitUpdate(vo);// 조회수 증가
		return "hospital/hospitalSelect";
	}

	// 검색...아..작스 ...처리

	@RequestMapping("/hospitalSearch")

	public String hospitalSearch(HospitalVO vo, String key, String val, Model model) {
		return "hospital/hospitalSearch";

	}

}
