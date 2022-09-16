package com.team.prj.attend.service.mapper;

import java.util.List;

import com.team.prj.attend.service.attendVO;

public interface attendMapper {
	List<attendVO> attendSelectList();
	attendVO attendSelect(attendVO vo);
	attendVO attendUpdate(attendVO vo);
}
