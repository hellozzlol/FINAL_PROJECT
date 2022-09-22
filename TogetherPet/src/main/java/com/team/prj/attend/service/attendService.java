package com.team.prj.attend.service;

import java.util.HashMap;
import java.util.List;

public interface attendService {
	List<HashMap<String,Object>> attendSelectList(int ad_no);
	attendVO attendSelect(attendVO tvo);
	attendVO attendInsert(attendVO tvo);
	attendVO attendUpdate(attendVO tvo);
}
