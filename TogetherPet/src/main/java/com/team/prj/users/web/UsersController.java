package com.team.prj.users.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.prj.board.service.BoardService;
import com.team.prj.cart.service.CartService;
import com.team.prj.cart.service.CartVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.comment.service.CommentService;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.like.service.LikesService;
import com.team.prj.orders.service.OrderService;
import com.team.prj.orders.service.OrderVO;
import com.team.prj.scrap.service.ScrapService;
import com.team.prj.state.service.StateService;
import com.team.prj.tutor.service.TutorService;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 주입
@Controller
public class UsersController {
	@Autowired
	private UsersService user; // 개인회원
	@Autowired
	private CartService cart; // 장바구니
	@Autowired
	private OrderService order; // 주문내역
	@Autowired
	private StateService state; // 반품교환상태
	@Autowired
	private ClassService classes; // 수강내역
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
	

	// 개인 회원 리스트
	@RequestMapping("/usersSelect")
	public String usersSelect(UsersVO vo, Model model) {
		vo.setUserNo(1);
		model.addAttribute("userList", user.usersSelect(vo));
		return "users/usersSelect";
	}

	// 개인 회원 리스트
//	@GetMapping("/usersSelect")
//	public String usersSelect(UsersVO vo, Model model) {
//		model.addAttribute("userList", dao.usersSelect(vo));
//		return "users/usersSelect";
//	}

	// 회원 정보 수정 폼 호출
	@RequestMapping("/usersUpdateForm")
	public String usersUpdateForm(UsersVO vo, Model model) {
		vo.setUserNo(1);
		model.addAttribute("userList", user.usersSelect(vo));
		return "users/usersUpdateForm";
	}

	// 회원 정보 수정
	@PostMapping("/usersUpdate")
	public String usersUpdate(UsersVO vo, Model model) {
		model.addAttribute("updateList", user.usersUpdate(vo));
		return "redirect:usersSelect";
	}

	// 마이페이지 주문 내역
	@RequestMapping("/usersOrderList")
	public String userOrder(CartVO vo, Model model) {
		model.addAttribute("orderList", cart.cartList(vo));
		return "users/usersOrderList";
	}

	// 마이페이지 장바구니
	@RequestMapping("/usersCartList") // cartList
	public String userCart(CartVO vo, Model model) {
		List<CartVO> list = cart.cartList(vo);
		model.addAttribute("cartList", list);
		return "users/usersCartList";
	}

	// 마이페이지 반품/교환 내역
	@RequestMapping("/usersCancelList")
	public String userCancel(OrderVO vo, Model model) {
		model.addAttribute("cancelList", state.stateSelect(vo));
		return "users/usersCancelList";
	}

	// 마이페이지 클래스 수강내역
	@RequestMapping("/usersClassList")
	public String userClass(Model model) {
		model.addAttribute("classList", classes.classSelectList());
		model.addAttribute("tutorList", tutor.tutorSelectList());
		return "users/usersClassList";
	}

	// 댓글 조회
	@GetMapping("/usersCommentList")
	public String userComment(CommentVO vo, Model model) {
		model.addAttribute("commentList", comment.commentSelectList());
		return "users/usersCommentList";
	}

	// 게시판 단건 조회
	@RequestMapping("/usersBoardList")
	public String userBoard(Model model) {
		model.addAttribute("boardList", board.boardSelectList());
		return "users/usersBoardList";
	}

	// 스크랩 전체 조회
	@RequestMapping("/usersScrapList")
	public String userScrap(Model model) {
		model.addAttribute("scrapList", scrap.scrapSelectList());
		return "users/usersScrapList";
	}
	
	// 위시리스트
	@RequestMapping("/usersWishList")
	public String userLike(Model model) {
		model.addAttribute("wishList", like.likeSelectList());
		return "users/usersWishList";
	}

}
