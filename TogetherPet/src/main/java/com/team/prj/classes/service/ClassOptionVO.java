package com.team.prj.classes.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassOptionVO {
	int classNo;
	int classOptionNo;
	String startDt;
	String endDt;
	String allHeadcount;
	
	//classOptionNo;
	//startDt;
	//endDt;
	//allHeadcount; 
	
	//조인 쿼리에서 쓰이는 외부테이블 칼럼
	int maxHeadcount; 
	int reserveNo; 
	String dt;
	String orderDate; 
	String pay;
	String payYn; 
	int userNo;
	int minusPrice; 
	int totalPrice; 
	String call;
	String name;
	int price;
	String className;
	
	int minusYn; //정산상태 0과 1로 표시하기 위함 10.08추가
	int minusN; //미정산 컬럼의 개수 카운트
	int minusY; //정산완료 컬럼의 개수 카운트
	int count; //리턴값 개수 카운트
	
	
	

}
