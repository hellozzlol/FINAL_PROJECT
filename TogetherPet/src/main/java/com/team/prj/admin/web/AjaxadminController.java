package com.team.prj.admin.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.prj.admin.service.adminService;
import com.team.prj.admin.service.adminVO;
import com.team.prj.attend.service.attendService;
import com.team.prj.attend.service.attendVO;
import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.seller.service.SellerService;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

@RestController
//@RequestMapping("/search")
public class AjaxadminController {
	
	@Autowired
	UsersService user;
	
	@Autowired
	SellerService seller;
	
	@Autowired
	TutorService tutor;
	
	@Autowired
	adminService admin;
	
	@Autowired
	BoardService board;
	
	@Autowired
	private attendService attend;

	// 일반회원 검색
	@ResponseBody
	@RequestMapping("userSearchAjax")
	public List<UsersVO> userSearch(String key, @RequestParam String val){
		return user.userSearch(key, val);
	}
	
	// 판매자 회원 검색 
	@ResponseBody
	@RequestMapping("sUserSearchAjax")
	public List<UsersVO> sUserSearch(String key, @RequestParam String val){
		return seller.sUserSearch(key, val) ;
	}
	
	// 튜터 회원 검색 
	@ResponseBody
	@RequestMapping("tUserSearchAjax")
	public List<TutorVO> tutorSearch(String key, @RequestParam String val){
		return tutor.tutorSearch(key, val) ;
	}
	
	
	// (관리자 페이지) 커뮤니티 글 삭제 
	@PostMapping("/ajaxboardDelete")
	public int boradDelete(BoardVO vo, Model model, int boardNo) {
		System.out.println("=====================" + vo.getBoardNo());
		return board.boardDelete(vo);

	}
	
	
	// 상품, 클래스 상태 업데이트
	@RequestMapping("postUpdateAjax")
	public int postUpdate(String category, int no){
		System.out.println("ajax===========");
		System.out.println(category);
		System.out.println(no);
		System.out.println("===========");
		int cnt = 0;
		GoodsVO g = new GoodsVO();
		ClassVO c = new ClassVO();
		if(category.toUpperCase().equals("C")) {
			c.setClassNo(no);
			cnt = admin.cpostUpdate(c);
		}else if(category.toUpperCase().equals("S")){
			g.setGoodsNo(no);
			cnt = admin.postUpdate(g);
		}
		return cnt;
	}
	
	
	// 출퇴근 등록
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/ajaxWorkIn")
		public String workIn(@RequestParam("checkVal") String checkVal, HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		adminVO ado = (adminVO) session.getAttribute("admin");
		attendVO ato = new attendVO();
		ato.setAdNo(ado.getAdNo());
		
		//날짜,시간 구해오기
		LocalDate now = LocalDate.now(); // 'yyyy-mm-dd'
		LocalTime time = LocalTime.now();
		ato.setState(0); // 디폴트 값 0(정상)으로 설정
		System.out.println("==============================");
		System.out.println(now);
		
		// 오늘 날짜 데이터 있는지 확인
		ato.setStartDt(now.toString()+" "+time.toString().substring(0, 8));
		List<HashMap<String,Object>> attendList = attend.attendSelectList(ato.getAdNo());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(attendList.contains(now.toString()));
		/*
		 * for(HashMap<String,Object> map : attendList) {
		 * if(map.get("START_DT").toString().substring(0, 8).equals(now.toString())) { }
		 * }
		 */
		
		
		//9시 넘으면 지각
		if(time.getHour()>9||(time.getHour()==9&&time.getMinute()>=1)){
			ato.setState(1);
		};
		String msg=null;
		if(checkVal.equals("OUT")) {
			//퇴근
			ato.setEndDt(ato.getStartDt());
			attend.updateWorkIn(ato);
			msg="퇴근 처리 되었습니다.";
		}else{
			//출근
			int a = 0;
			for(int i=0; i<attendList.size();i++) {
				String n = now.toString();
				String at = attendList.get(i).get("START_DT").toString().substring(0,10);
				System.out.println(n);
				System.out.println("==================");
				System.out.println(at);
				System.out.println("==================");
				System.out.println(n.equals(at));
				
				if(n.equals(at)) {
					a = 1;
					break;
				}
			}
			if(a==1) {
				msg="이미 출근 등록 되었습니다.";
			}else {
				attend.insertWorkIn(ato);
				msg="출근 처리 되었습니다.";
			}
		} 
			return msg; 
		}

}
