package com.team.prj.attend.service;

import java.util.List;

public interface attendService {
	List<attendVO> attendSelectList(attendVO tvo);
	attendVO attendSelect(attendVO tvo);
	attendVO attendUpdate(attendVO tvo);
}
