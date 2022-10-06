package com.team.prj.attend.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class attendVO {
	int adNo;
	String startDt;
	String endDt;
//	Date Dt; // 0922 지움
	int state;
	// String workCk; // 0923 추가
	int atNo; //1001 추가
}
