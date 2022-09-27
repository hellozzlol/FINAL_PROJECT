package com.team.prj.board.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService dao;

	
	@Value("${file.dir}")
    private String fileDir;

	// 유저 게시판 전체 조회
	@GetMapping("/boardSelectList")
	public String boardSelectList(Model model) {
		model.addAttribute("boardList", dao.boardSelectList());
		return "users/boardSelectList";
	}

	// 유저 게시판 단건 조회
	@GetMapping("/boardSelect")
	public String boardSelect(BoardVO vo, Model model) {
		model.addAttribute("boardList", dao.boardSelect(vo));
		return "users/boardSelect";
	}
	
	//유저  글등록 폼 호출
	@RequestMapping("/boardForm")
	public String boardForm() {
		return "users/boardForm";
	}
	
	// 유저  글등록
	@PostMapping("/boardInsert")
	public String boardInsert() {
		return "redirect:boardSelectList";
	}
	
	
	
	/////////////////////이 밑으론 커뮤니티 //////////////////
	
	
	//커뮤니티게시판조회
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", dao.boardSelectList());
		return "board/boardList";
	}

	//커뮤니티게시판상세조회
		@GetMapping("/boardSel")
		public String boardselect(BoardVO vo, Model model) {
			System.out.println("=====================" + vo.getBoardNo());
			
			model.addAttribute("boardSel",dao.boardSelect(vo));
			dao.boardHitUpdate(vo);//조회수증가
			return "board/boardSel";
		}
	
	//커뮤니티글쓰기폼호출
		@RequestMapping("/boardFom")
		public String boardform() {
			return "board/boardFom";
		}
		
		
	//커뮤니티 글 등록	
		@PostMapping("/boardIns")
		
		public String boardInsert(BoardVO vo ,
				@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
			
			//file UpLoad 처리해야함.
			String saveFolder  = (""); //저장할 공간 변수 명 
			System.out.println(saveFolder);
			File sfile = new File(saveFolder);//물리적 저장할 위치
			String oFileName = file.getOriginalFilename();//넘어온 파일의 이름 .원래파일네임
			if(!oFileName.isEmpty()) {
				
				//파일명 충돌방지를 위한 별명 만듦
				String sFileName = UUID.randomUUID().toString() 
						+ oFileName.substring(oFileName.lastIndexOf(".")); //파일확장자찾는것 //랜덤파일네임
				String path = fileDir+"/"+sFileName;
				file.transferTo(new File(path)); //파일을 물리적 위치에 저장한다.
						
				vo.setAttech(oFileName);
				vo.setAttechDir(saveFolder +"/"+sFileName);
			}
		    
			dao.boardInsert(vo);
			return "redirect:boardList";
		}
			
		
		//커뮤니티 글 삭제
		
		@GetMapping("/boardDelete")
		
		public String boradDelete(BoardVO vo, Model model, @RequestParam("boardNo") int boardNo) {
			System.out.println("=====================" + vo.getBoardNo());
			vo.setBoardNo(Integer.parseInt(("boardNo")));
			dao.boardDelete(vo);
			return "redirect:boardList";
			
		}
		
		
		//검색 아..작..스..처..리..리ㅣㅣ리ㅣ리리리리리이이이ㅣ잉
		
		@RequestMapping("/boardSearch")
		
		public String boarSearch(BoardVO vo,String key, String val, Model model) {
		return "board/boardSearch";

		}	
}
