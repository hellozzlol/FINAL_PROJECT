package com.team.prj.classes.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.prj.classes.service.ClassOptionVO;
import com.team.prj.classes.service.ClassService;
import com.team.prj.classes.service.ClassVO;
import com.team.prj.classexreserve.service.ClassExreserveService;
import com.team.prj.classexreserve.service.ClassExreserveVO;
import com.team.prj.classreserve.service.ClassReserveService;
import com.team.prj.classreserve.service.ClassReserveVO;
import com.team.prj.photo.service.PhotoVO;
import com.team.prj.review.service.ReviewService;
import com.team.prj.review.service.ReviewVO;


@ControllerAdvice
@Controller
public class ClassAjaxController {
	
	@Autowired
	private ClassService classDao;
	@Autowired
	private ClassExreserveService exreserveDao;
	@Autowired
	private ClassReserveService reserveDao;
	@Autowired
	private ReviewService reviewDao;
	@Value("${file.dir}")
	private String fileDir;
	
	
	//클래스 리스트에서 검색하는 ajax
	@RequestMapping("classSearch")
	@ResponseBody
	public List<ClassVO> classSearch(Model model, ClassVO vo){
		return classDao.classSearch(vo);
	}
	
	
	//클래스 단건조회에서 일정 달력 ajax
	@RequestMapping("classDateOption")
	@ResponseBody
	public List<ClassOptionVO> classDateOption(Model model, String sdate, int no, ClassVO vo){
		List<ClassOptionVO> list = classDao.classDateOption(sdate, no);
		model.addAttribute("option", list);
		System.out.println("여기까지오긴하는거니..?");
		return list;
	}
	
	//클래스 단건조회에서 리뷰 등록
	@RequestMapping("classReviewInsert")
	@ResponseBody
	public ReviewVO classReviewInsert(ReviewVO revo, Model model) {
		//리뷰 정보 인서트
		reviewDao.reviewInsert(revo);
	
		//닉네임 포함된 값으로 다시 조회
		ReviewVO result = classDao.classReviewSelect(revo);

		return result;
	}
	
	
	// 주문 및 결제 하기 (등록)
	@RequestMapping("classReserveInsert")
	@ResponseBody
	public int orderInsert(ClassReserveVO vo, Model model) {
		//예약정보 인서트
		reserveDao.classReserveInsert(vo);
		int reserveNo = vo.getReserveNo();
		int money = vo.getMoney();
		System.out.println("예약정보 인서트 완료");
		
		//선택한 클래스옵션 타임에 인원 +1
		ClassOptionVO opvo = new ClassOptionVO();
		int classOptionNo = vo.getClassOptionNo();
		opvo.setClassOptionNo(classOptionNo);
		reserveDao.updateHeadCount(opvo);
		System.out.println("클래스 신청인원 +1완료");
		
		//예약전 정보 삭제
		ClassExreserveVO exvo = new ClassExreserveVO();
		int exreserveNo = exvo.getExreserveNo();
		exvo.setExreserveNo(exreserveNo);
		exreserveDao.classExreserveDelete(exvo);
		System.out.println("예약 전 임시정보 삭제 완료");
		
		System.out.println("===========" + exreserveNo);
		System.out.println("===========" + reserveNo);
		System.out.println("===========" + money);

		return reserveNo;
	}
	
	// 클래스 등록하기
	@RequestMapping("classInsert")
	@ResponseBody
	public int classInsert(ClassVO vo, Model model) {
		//클래스정보 인서트
		classDao.classInsert(vo);
		int classNo = vo.getClassNo();
		System.out.println("클래스 인서트 완료 : " + classNo);

		return classNo;
	}
	
	
	//클래스 등록에서 옵션 등록
	@RequestMapping("classOptionInsert")
	@ResponseBody
	public void classOptionInsert(@RequestBody List<Map<String,Object>> opparams) {
		//데이터를 담아줄 map 생성 
		HashMap<String,Object> opmap = new HashMap<String,Object>(); 

		opmap.put("optionList", opparams);
		System.out.println("클래스 옵션 맵에 담음");
		
		try {
			classDao.classOptionInsert(opmap);
		} catch (Exception e) {
			System.out.println("---hashmap 바인딩 오류 예외처리함---");
		}

	}
	
	//클래스 등록에서 이미지리스트 등록
	@RequestMapping("classPhotoInsert")
	@ResponseBody
	public void classPhotoInsert(@RequestBody List<Map<String,Object>> ptparams) {
		//데이터를 담아줄 map 생성 
		HashMap<String,Object> ptmap = new HashMap<String,Object>(); 

		ptmap.put("photoList", ptparams);
		System.out.println("그룹사진 맵에 담음");
		try {
			classDao.classPhotoInsert(ptmap);
		} catch (Exception e) {
			System.out.println("---hashmap 바인딩 오류 예외처리함---");
		}
		
	}

	
	//이미지리스트 정보를 서버에 담아줌
	@PostMapping(value="classPhoto", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	 public ResponseEntity<List<PhotoVO>> classPhoto(MultipartFile[] uploadFile){
		
		///// 이미지 파일 맞는지 체크 /////
		for(MultipartFile multipartFile: uploadFile) {
			File checkfile = new File(multipartFile.getOriginalFilename());
			String type = null;
			try {
				type = Files.probeContentType(checkfile.toPath());
				System.out.println("MIME TYPE : " + type);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(!type.startsWith("image")) {
				
				List<PhotoVO> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
			}
		}///// 이미지 파일 맞는지 체크 end/////
		
		

		//파일 경로를 저장하는 String 타입의 변수를 선언하고 초기화
		String uploadFolder = "C:\\Users\\admin\\git\\FINAL_PROJECT\\TogetherPet\\src\\main\\resources\\Temp";
		//테스트용 admin부분 지민노트북 이름으로 임시변경
		//String uploadFolder = "C:\\Users\\dhwla\\git\\FINAL_PROJECT\\TogetherPet\\src\\main\\resources\\Temp";
		
		//File객체를 사용해 폴더 생성
		File uploadPath = new File(uploadFolder); //물리적 저장할 위치		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		

		// 이미지 정보 담는 객체
		List<PhotoVO> list = new ArrayList();	
		//향상된 for문
		for(MultipartFile multipartFile : uploadFile) {
			//이미지 정보 객체
			PhotoVO vo = new PhotoVO();		
			//파일 이름
			String uploadFileName = multipartFile.getOriginalFilename();		
			// uuid 적용 파일 이름
			String uuid = UUID.randomUUID().toString();
			uploadFileName = uuid + "_" + uploadFileName;		
			// 파일 위치, 파일 이름을 합친 File 객체
			File saveFile = new File(uploadPath, uploadFileName);			
			//포토 vo에 경로넣기
			//vo.setDir(uploadFolder+ "\\" + uploadFileName);
			vo.setDir(uploadFileName);
			vo.setName("리스트");
			vo.setGroupNo(classDao.getGroupNo()+10);
			// 파일 저장
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//이미지 정보가 저장된 photoVO객체를 List의 요소로 추가
			list.add(vo);

		}//for문

		ResponseEntity<List<PhotoVO>> result = new ResponseEntity<List<PhotoVO>>(list, HttpStatus.OK);
		
		
		//classDao.photoInsert(result);
		//System.out.println("그룹사진 인서트 완료");
		
		//PhotoVO vo = new PhotoVO();	
		//int groupNo = vo.getGroupNo();
		//vo.setGroupNo(groupNo);
		
	 

			
		return result;
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName){
		File file = new File("C:\\Users\\admin\\git\\FINAL_PROJECT\\TogetherPet\\src\\main\\resources\\Temp\\" + fileName);
		//테스트용 admin부분 지민노트북 이름으로 임시변경
		//File file = new File("C:\\Users\\dhwla\\git\\FINAL_PROJECT\\TogetherPet\\src\\main\\resources\\Temp\\" + fileName);
		ResponseEntity<byte[]> result = null;
		
		try {

			MultiValueMap<String,String> header = new LinkedMultiValueMap<String, String>();
	
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	
}
