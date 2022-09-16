package com.team.prj.attend.service;

import java.util.List;

public interface attendService {
	List<attendVO> attendSelectList();
	attendVO attendSelect(attendVO vo);
	attendVO attendUpdate(attendVO vo);
}
