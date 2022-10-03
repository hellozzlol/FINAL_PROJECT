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
	private String cancelDetail; // 반품 상세 사유
	private String cancelSel; // 반품 방법
	private String cancelAccount; // 반품 계좌
	private String cancelAccountNum; // 반품 계좌 번호
	private String change; // 교환 사유
	private String changeDetail; // 교환 상세 사유
	private String changeSel; // 교환 방법 1001 선희 DB에 추가
}
