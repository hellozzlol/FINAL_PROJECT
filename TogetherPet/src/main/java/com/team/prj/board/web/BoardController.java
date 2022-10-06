package com.team.prj.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.prj.board.service.BoardService;
import com.team.prj.board.service.BoardVO;
import com.team.prj.comment.service.CommentVO;
import com.team.prj.users.service.UsersService;
import com.team.prj.users.service.UsersVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@Autowired
	private UsersService user; // 개인회원

	@Value("${file.dir}")
	private String fileDir;

	// 유저 게시판 전체 조회
	@GetMapping("/boardSelectList")
	public String boardSelectList(Model model) {
		model.addAttribute("boardList", service.boardSelectList());
		return "users/boardSelectList";
	}

	// 유저 게시판 단건 조회
	@GetMapping("/boardSelect")
	public String boardSelect(BoardVO vo, Model model) {
		model.addAttribute("boardList", service.boardSelect(vo));
		return "users/boardSelect";
	}

	// 유저 글등록 폼 호출
	@RequestMapping("/boardForm")
	public String boardForm() {
		return "users/boardForm";
	}

	// 유저 글등록
	@PostMapping("/boardInsert")
	public String boardInsert() {
		return "redirect:boardSelectList";
	}

	///////////////////// 이 밑으론 커뮤니티 //////////////////

	// 커뮤니티게시판조회
	@GetMapping("/boardList")
	public String boardList(BoardVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		/* model.addAttribute("boardList", dao.boardSelectList()); */
		model.addAttribute("pageInfo", PageInfo.of(service.boardSelectList()));
		return "board/boardList";
	}

	// 커뮤니티게시판상세조회
	@GetMapping("/boardSel")
	public String boardselect(BoardVO vo,CommentVO cvo ,Model model) {
		System.out.println("=====================" + vo.getBoardNo());
		BoardVO b = service.boardSelect(vo);
		//b.setAttechDir( "C:\\Users\\admin\\git\\FINAL_PROJECT\\TogetherPet\\src\\main\\resources\\Temp"+b.getAttechDir());
		System.out.println("============================"+b.getAttechDir());
		model.addAttribute("boardSel", b);

		// 조회수증가
		service.boardHitUpdate(vo);
		
		//댓글리스트
		cvo.setCommentNo(vo.getBoardNo());
		model.addAttribute("commentSelectList",service.commentSelectList(cvo));
		return "board/boardSel";
	}

	// 커뮤니티글쓰기폼호출
	@RequestMapping("/boardFom")
	public String boardform() {
		return "board/boardFom";
	}

	// 커뮤니티 글 등록
	@PostMapping("/boardIns")

	public String boardInsert(BoardVO vo, 
			                  @RequestParam("file") MultipartFile file, 
			                  HttpServletRequest request)
			throws IllegalStateException, IOException {

		HttpSession session = request.getSession();
		UsersVO uvo = (UsersVO) session.getAttribute("user");
		vo.setUserNo(uvo.getUserNo());
		vo.setNickname(uvo.getNickname());
		// file UpLoad 처리해야함.
		String saveFolder = ("");//저장할변수명 
		System.out.println(saveFolder);
		File sfile = new File(saveFolder);// 물리적 저장할 위치
		System.out.println(sfile);
		String oFileName = file.getOriginalFilename();// 넘어온 파일의 이름 .원래파일네임
		
		if (!oFileName.isEmpty()) {

			// 파일명 충돌방지를 위한 별명 만듦
			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf(".")); // 파일확장자찾는것																									// //랜덤파일네임
			String path = fileDir + "/" + sFileName;
			file.transferTo(new File(path)); // 파일을 물리적 위치에 저장한다.
			vo.setAttech(oFileName);
			vo.setAttechDir(saveFolder + "/" + sFileName);
		}

		service.boardInsert(vo);
		return "redirect:boardList";
	}
	
	//커뮤니티 파일 다운로드
	@GetMapping(value = "/download")
    public void download(String fileName, HttpServletResponse response, HttpServletRequest request){

        try {
            String originFileName = URLDecoder.decode(fileName, "UTF-8");
            String onlyFileName = originFileName.substring(originFileName.lastIndexOf("_") + 1);

            File file = new File("C:\\Temp", originFileName);
            
            if(file.exists()) {
                String agent = request.getHeader("User-Agent");

                //브라우저별 한글파일 명 처리
                if(agent.contains("Trident")) {//Internet Explore
                    onlyFileName = URLEncoder.encode(onlyFileName, "UTF-8").replaceAll("\\+", " ");
                }    
                else if(agent.contains("Edge")) { //Micro Edge
                    onlyFileName = URLEncoder.encode(onlyFileName, "UTF-8");
                    
                }else {//Chrome
                    onlyFileName = new String(onlyFileName.getBytes("UTF-8"), "ISO-8859-1");
                }
                //브라우저별 한글파일 명 처리

                response.setHeader("Content-Type", "application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; filename=" + onlyFileName);

                InputStream is = new FileInputStream(file);
                OutputStream os = response.getOutputStream();

                int length;
                byte[] buffer = new byte[1024];

                while( (length = is.read(buffer)) != -1){
                    os.write(buffer, 0, length);
                }

                os.flush();
                os.close();
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	
	// 커뮤니티 글 삭제

	@PostMapping("/boardDelete")

	public String boradDelete(BoardVO vo, Model model, int boardNo) {
		System.out.println("=====================" + vo.getBoardNo());
		// vo.setBoardNo(Integer.parseInt(("boardNo")));
		service.boardDelete(vo);
		return "redirect:boardList";

	}

	// 커뮤니티 글 수정폼불러오기

	@GetMapping("/boardUpdateForm")

	public String boardUpdate(BoardVO bvo, Model model ,HttpSession session) {

		UsersVO vo = new UsersVO();
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		
		vo = user.usersSelect(vo);
		model.addAttribute("userList", vo);
		model.addAttribute("boardSel", service.boardSelect(bvo));
		return "board/boardUpdateForm";
	}

	// 커뮤니티 글 수정하기

	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {

		System.out.println("=======" + request.getParameter("boardNo"));
		
		
		if (!file.getOriginalFilename().isEmpty()) {
			
			String boardupd = System.getProperty("user.dir") + "/"; // 프로젝트 경로
			//기존파일 삭제 
			
			
			//새로운파일업로드 
			UUID uuid = UUID.randomUUID();
			String filename = uuid + "_" + file.getOriginalFilename();
			File saveFile = new File(boardupd, filename);
			file.transferTo(saveFile);
			vo.setAttech(filename);
			String path = fileDir+"/files/" + filename;
			vo.setAttechDir(path);
		}

		service.boardUpdate(vo);
		return "redirect:boardList";

	}

	@RequestMapping("/boardSearch")

	public String boarSearch() {
		return "board/boardSearch";

	}
	
	
	
	

	
	
}