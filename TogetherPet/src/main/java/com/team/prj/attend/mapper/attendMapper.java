package com.team.prj.attend.mapper;

import java.util.List;

import com.team.prj.attend.service.attendVO;

public interface attendMapper {
	List<attendVO> attendSelectList(attendVO tvo);
	attendVO attendSelect(attendVO tvo);
	attendVO attendUpdate(attendVO tvo);
}
