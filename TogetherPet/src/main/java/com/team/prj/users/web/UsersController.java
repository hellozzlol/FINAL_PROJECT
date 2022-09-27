package com.team.prj.users.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.board.service.BoardService;
import com.team.prj.calendar.service.CalendarService;
import com.team.prj.calendar.service.CalendarVO;
import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classreserve.service.ClassReserveService;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.comment.service.CommentService;
import com.team.prj.like.service.LikesService;
import com.team.prj.orders.service.OrderService;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.pet.service.PetService;
import com.team.prj.pet.service.PetVO;
import com.team.prj.scrap.service.ScrapService;
import com.team.prj.seller.service.SellerVO;
import com.team.prj.state.service.StateService;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.tutor.service.TutorVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 주입
@Controller
public class UsersController {
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private UsersService user; // 개인회원
	@Autowired
	private CartService cart; // 장바구니
	@Autowired
	private OrderService order; // 주문내역
	@Autowired
	private StateService state; // 반품교환상태
	@Autowired
	private CommentService comment; // 댓글조회
	@Autowired
	private BoardService board; // 작성글조회
	@Autowired
	private ScrapService scrap; // 스크랩 내역
	@Autowired
	private TutorService tutor; // 클래스 튜터
	@Autowired
	private LikesService like; // 위시리스트
	@Autowired
	private CalendarService cal; // 캘린더
	@Autowired
	private PetService pet; // 반려동물 정보
	@Autowired
	private ClassReserveService cr; // 수강내역

	// 개인 회원 리스트
	@RequestMapping("/users/usersSelect")
	public String usersSelect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		user.usersSelect(vo);
		return "users/usersSelect";
	}

	// 회원 정보 수정 폼 호출
	@RequestMapping("/users/usersUpdateForm")
	public String usersUpdateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UsersVO vo = new UsersVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = user.usersSelect(vo);
		request.setAttribute("userList", vo);
		return "users/usersUpdateForm";
	}

	// 회원 정보 수정 처리
	@PostMapping("/users/usersUpdate")
	public String usersUpdate(UsersVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		user.usersUpdate(vo);
		vo = user.usersSelect(vo);
		session.setAttribute("user", vo);
		return "redirect:/users/usersSelect";
	}

	// 마이페이지 주문 내역
	@RequestMapping("/users/usersOrderList")
	public String orderList(OrderVO ovo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		ovo.setUserNo(vo.getUserNo());
		List<OrderVO> list = user.orderList(ovo);
		model.addAttribute("orderList", list);
		return "users/usersOrderList";
	}

	// 회원 탈퇴
	@RequestMapping("/users/usersDelete")
	public String usersDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		user.usersDelete(vo);
		return "index";
	}

	// 마이페이지 장바구니
	@RequestMapping("/users/usersCartList")
	public String userCart(CartVO vo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsersVO u = (UsersVO) session.getAttribute("user");
		vo.setUserNo(u.getUserNo());
		model.addAttribute("cartList", user.cartList(vo));
		return "users/usersCartList";
	}

	// 마이페이지 반품/교환 내역
	@RequestMapping("/users/usersCancelList")
	public String userCancel(OrderVO vo, Model model) {
		model.addAttribute("cancelList", state.stateSelect(vo));
		return "users/usersCancelList";
	}

	// 마이페이지 클래스 수강내역
	@RequestMapping("/users/usersClassList")
	public String userClass(ClassReserveVO crvo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		crvo.setUserNo(vo.getUserNo());
		List<ClassVO> list = user.classList(crvo);
		model.addAttribute("classList", list);
		return "users/usersClassList";
	}

	// 댓글 조회
	@RequestMapping("/users/usersCommentList")
	public String userComment(Model model) {
		model.addAttribute("commentList", comment.commentSelectList());
		return "users/usersCommentList";
	}

	// 게시판 단건 조회
	@RequestMapping("/users/usersBoardList")
	public String userBoard(Model model) {
		model.addAttribute("boardList", board.boardSelectList());
		return "users/usersBoardList";
	}

	// 스크랩 전체 조회
	@RequestMapping("/users/usersScrapList")
	public String userScrap(Model model) {
		model.addAttribute("scrapList", scrap.scrapSelectList());
		return "users/usersScrapList";
	}

	// 위시리스트
	@RequestMapping("/users/usersWishList")
	public String userLike(Model model) {
		model.addAttribute("wishList", like.likeSelectList());
		return "users/usersWishList";
	}

	// 전체 일정 조회
	@RequestMapping("/users/calendarSelectList")
	public String calendarSelectList() {
		return "calendar/calendarSelectList";
	}

	// 일정 상세 조회
	@RequestMapping("/calendar/calendarSelect")
	public String calendarSelect(CalendarVO vo, Model model) {
		model.addAttribute("cal", cal.calendarSelect(vo));
		return "calendar/calendarSelect";
	}

	// 일정 등록 처리
	@PostMapping("/users/calendarInsert")
	public String calendarInsert(CalendarVO vo) {
		return "redirect:calendar/calendarSelect";
	}
	
	// 반려동물 전체 리스트
	@RequestMapping("/pet/petSelectList")
	public String petSelectList(HttpServletRequest request, Model model, PetVO pvo) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		pvo.setUserNo(vo.getUserNo());
		model.addAttribute("petList", pet.petSelectList(pvo));
		return "pet/petSelectList";
	}

	// 반려동물 단건 조회
	@RequestMapping("/pet/petSelect")
	public String petSelect(HttpServletRequest request, PetVO pvo, Model model) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		pvo.setUserNo(vo.getUserNo());
		model.addAttribute("petList", pet.petSelect(pvo));
		return "pet/petSelect";
	}
	
	// 반려동물 정보 수정 폼 호출
	@RequestMapping("/pet/petUpdateForm")
	public String petUpdateForm(HttpServletRequest request, PetVO pvo, Model model) {
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO) session.getAttribute("user");
		pvo.setUserNo(vo.getUserNo());
		model.addAttribute("petList", pet.petSelect(pvo));
		return "pet/petUpdateForm";
	}

	// 반려동물 정보 수정 처리
//	@PostMapping("/pet/petUpdate")
//	public String petUpdate(PetVO pvo, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.setAttribute("pet", pet.petUpdate(pvo));
//		return "redirect:/pet/petSelectList";
//	}
	
	@PostMapping("/pet/petUpdate")
	public String petUpdate(PetVO pvo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("=================" + pvo==null);
		pet.petUpdate(pvo);
		pvo = pet.petSelect(pvo);
		session.setAttribute("pet", pvo);
		return "redirect:/pet/petSelectList";
	}

	// 반려동물 정보 등록 폼 호출
	@RequestMapping("/pet/petInsertForm")
	public String perInsertForm() {
		return "pet/petInsertForm";
	}

	// 반려동물 정보 등록 처리
//	@PostMapping("/pet/petInsert")
//	public String petInsert(PetVO vo, @RequestPart(value = "file", required = false) MultipartFile file)
//			throws IllegalStateException, IOException {
//		// 파일 업로드 처리
//		String saveFolder = servletContext.getRealPath("/fileUpload"); // 파일 저장할 폴더 변수명
//		File sfile = new File(saveFolder); // 물리적 저장 위치
//		String ofileName = file.getOriginalFilename(); // 넘어온 파일명
//		PhotoVO pvo = new PhotoVO();
//		if (!ofileName.isEmpty()) {
//			String sfileName = UUID.randomUUID().toString() + ofileName.substring(ofileName.lastIndexOf(".")); // 파일명
//			file.transferTo(new File(sfile, sfileName)); // 파일 전송, 물리적 위치에 저장
//			pvo.setName(ofileName);
//			pvo.setDir(saveFolder + File.separator + sfileName);
//			// File.separator(파일의 경로를 분리해주는 메소드) == //
//		}
//		pet.petInsert(vo);
//		return "redirect:pet/petSelectList";
//	}

	@PostMapping("/pet/petInsert")
	public String memberInsert(PetVO vo, Model model) {
		int m = pet.petInsert(vo);
		if (m != 0) {
			model.addAttribute("message", "정상적으로 등록되었습니다.");
		} else {
			model.addAttribute("message", "등록이 실패했습니다.");
		}
		return "redirect:pet/petSelectList";
	}

}
