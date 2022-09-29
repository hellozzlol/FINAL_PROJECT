package com.team.prj.state.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateVO {
	private int orderNo; // 주문번호
	private String state; // 상태
	private Date cancelDt; // 반품신청일자
	private Date cancelCfDt; // 반품완료일자
	private Date changeDt; // 교환신청일자
	private Date changeCfDt; // 교환완료일자
	
	// 0929 선희 DB에 추가
	private String cancel; // 반품 사유
	private String cancel_detail; // 반품 상세 사유
	private String cancel_sel; // 반품 방법
	private String cancel_account; // 반품 계좌
	private String cancel_account_num; // 반품 계좌 번호
	private String change; // 교환 사유
	private String change_detail; // 교환 상세 사유
}
