package com.team.prj.attend.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class attendVO {
	int adNo;
	Date startDt;
	Date endDt;
//	Date Dt; // 0922 지움
	int state;
}
