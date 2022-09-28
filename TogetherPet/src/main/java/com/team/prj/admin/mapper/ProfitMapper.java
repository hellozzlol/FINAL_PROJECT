package com.team.prj.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.team.prj.admin.service.ProfitVO;

public interface ProfitMapper {
	// 0928 희수 추가
	List<ProfitVO> profitList(@Param("start") String start,@Param("end") String end);


	ProfitVO profitSelect(ProfitVO vo);
	
	Map monthlyList(@Param("key") String key);
	
}
