package com.team.prj.accomo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.prj.accomo.service.accomoVO;
import com.team.prj.review.service.ReviewVO;
import com.team.prj.scrap.service.ScrapVO;

public interface accomoMapper {
	List<accomoVO> accomoSelectList(@Param("key") String key);

	accomoVO accomoSelect(accomoVO vo);

	int accomoInsert(accomoVO vo);

	int accomoUpdate(accomoVO vo);

	int accomoDelete(accomoVO vo);
	
	//조회수 증가
	int accomoHitUpdate(accomoVO vo);
	
	//검색기능
	
	List<accomoVO> accomoSearch(@Param("key")String key, @Param("val") String val);

	
	
	
	//소현스크랩기능
	  int scrapInsert(ScrapVO vo);//20221005소현추가
	  
	//소현 리뷰기능 20221008
		List<ReviewVO> accomoreviewSelectList(accomoVO vo);
		
		ReviewVO accomoreviewSelect(ReviewVO vo);
		
		int reviewInsert(ReviewVO vo);
		
		int reviewUpdate(ReviewVO vo);
		
		int reviewDelete(ReviewVO vo);
	
	
}
