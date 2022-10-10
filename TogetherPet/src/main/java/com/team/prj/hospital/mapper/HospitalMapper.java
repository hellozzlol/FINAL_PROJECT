package com.team.prj.hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.hospital.service.HospitalVO;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.scrap.service.ScrapVO;

public interface HospitalMapper {
	List<HospitalVO> hospitalSelectList(@Param("key") String key);

	HospitalVO hospitalSelect(HospitalVO vo);

	int hospitalInsert(HospitalVO vo);

	int hospitalUpdate(HospitalVO vo);

	int hospitalDelete(HospitalVO vo);
	//조회수 증가
	int hospitalHitUpdate(HospitalVO vo);
	
	//검색기능
	//제목에 어떤내용이 들어있으면 다 불러오라(내용도 마찬가지)
    //메퍼에선 둘이상이 전달될때는 앞쪽에다가 (@Param("속성명"),(@Param("값의 타입을 써주면된당") 적어줘야함 중요도******
	
	List<HospitalVO> hospitalSearch(@Param("key")String key, @Param("val") String val);

	//소현스크랩기능
	int scrapInsert(ScrapVO vo);//20221005소현추가
	
	
	//소현 리뷰기능 20221008
	List<ReviewVO> hospitalreviewSelectList(HospitalVO vo);
	
	ReviewVO hospitalreviewSelect(ReviewVO vo);
	
	int reviewInsert(ReviewVO vo);
	
	int reviewUpdate(ReviewVO vo);
	
	int reviewDelete(ReviewVO vo);
}
