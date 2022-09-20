package com.team.prj.attend.mapper;


import java.util.HashMap;
import java.util.List;

import com.team.prj.attend.service.attendVO;

public interface attendMapper {

	List<attendVO> attendSelectList();
	List<HashMap<String,Object>> attendSelectList(int ad_no);

	attendVO attendSelect(attendVO tvo);
	attendVO attendUpdate(attendVO tvo);
}
