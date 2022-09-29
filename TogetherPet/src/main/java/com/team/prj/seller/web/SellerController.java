package com.team.prj.seller.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.goods.service.GoodsVO;
import com.team.prj.seller.service.SellerService;
import com.team.prj.seller.service.SellerVO;

@Controller
public class SellerController {
	@Autowired
	private SellerService seller;
	@Value("${file.dir}")
	private String fileDir;

	// 판매자 회원 전체 조회
	@RequestMapping("/sellerSelectList")
	public String sellerSelectList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerSelectList";
	}

	// 판매자 회원(개인정보) 단건 조회
	@RequestMapping("/sellerMyPage")
	public String sellerMyPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SellerVO vo = (SellerVO) session.getAttribute("seller");
		seller.sellerMyPage(vo);
		return "seller/sellerMyPage";
	}

	// 판매자 회원(개인정보) 수정 폼 호출
	@RequestMapping("/sellerMyPageUpdForm")
	public String sellerMyPageUpdForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		SellerVO vo = new SellerVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = seller.sellerMyPage(vo);
		request.setAttribute("sellerList", vo);
		return "seller/sellerMyPageUpdForm";
	}

	// 판매자 회원(개인정보) 수정
	@PostMapping("/sellerMyPageUpd")
	public String sellerUpdate(SellerVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		seller.sellerUpdate(vo);
		vo = seller.sellerMyPage(vo);
		session.setAttribute("seller", vo);
		return "redirect:/sellerMyPage";
	}

	// 판매자 회원(사업자) 단건 조회
	@RequestMapping("/sellerComList")
	public String sellerComList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SellerVO vo = (SellerVO) session.getAttribute("seller");
		seller.sellerMyPage(vo);
		return "seller/sellerComList";
	}

	// 판매자 정보(사업자) 수정 폼 호출
	@RequestMapping("/sellerComUpForm")
	public String sellerComUpForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		SellerVO vo = new SellerVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = seller.sellerMyPage(vo);
		request.setAttribute("sellerList", vo);
		return "seller/sellerComUpForm";
	}

	// 판매자 정보(사업자) 수정 처리
	@PostMapping("/sellerComUpdate")
	public String sellerComUpdate(SellerVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		seller.sellerUpdate(vo);
		vo = seller.sellerMyPage(vo);
		session.setAttribute("seller", vo);
		return "redirect:/sellerComList";
	}

	// 판매 상품 등록 폼 호출
	@RequestMapping("/sellerGIForm")
	public String sellerGoodsInsert() {
		return "seller/sellerGIForm";
	}

	// 판매 상품 등록 처리
	@PostMapping("/sellerGI")
	public String goodsInsert(Model model, HttpServletRequest request, GoodsVO gvo,
			@RequestPart(value = "file", required = false) MultipartFile file)
			throws IllegalStateException, IOException {
		HttpSession session = request.getSession();
		SellerVO svo = new SellerVO();
		svo.setSellerNo(gvo.getSellerNo());
		model.addAttribute("goodsList", seller.goodsList(gvo));

		// file UpLoad 처리해야함.
		String saveFolder = (""); // 저장할 공간 변수 명
		System.out.println(saveFolder);
		File sfile = new File(saveFolder);// 물리적 저장할 위치
		String oFileName = file.getOriginalFilename();// 넘어온 파일의 이름.원래파일네임
		if (!oFileName.isEmpty()) {

			// 파일명 충돌방지를 위한 별명 만듦
			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf(".")); // 파일확장자찾는것,
																												// 랜덤파일네임
			String path = fileDir + "/" + sFileName;
			file.transferTo(new File(path)); // 파일을 물리적 위치에 저장

			svo.setAttach(oFileName);
			svo.setAttachDir(saveFolder + "/" + sFileName);
		}
		seller.goodsInsert(gvo);
		return "redirect:/sellerGoodsList";
	}

	// 판매 상품 조회
	@RequestMapping("/sellerGoodsList")
	public String sellerGoodsList(Model model, HttpServletRequest request, GoodsVO gvo,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		HttpSession session = request.getSession();
		SellerVO svo = (SellerVO) session.getAttribute("seller");
		gvo.setSellerNo(svo.getSellerNo());
		model.addAttribute("pageInfo", PageInfo.of(seller.goodsList(gvo)));
		return "seller/sellerGoodsList";
	}

	// 배송 관리 페이지
	@RequestMapping("/sellerDeliList")
	public String sellerDeliList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerDeliList";
	}

	// 취소/반품 관리 페이지
	@RequestMapping("/sellerCanList")
	public String sellerCanList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerCanList";
	}

	// 판매완료 상품 관리 페이지
	@RequestMapping("/sellerDoneList")
	public String sellerDoneList(Model model) {
		model.addAttribute("sellerList", seller.sellerSelectList());
		return "seller/sellerDoneList";
	}

}
