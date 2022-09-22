package com.team.prj.state.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateVO {
	private int orderNo; // 주문번호
	private String state; // 상태
	private Date cancelDt, cancelCfDt, changeDt, changeCfDt;
	// 반품신청일자, 반품완료일자, 교환신청일자, 교환완료일자
}
