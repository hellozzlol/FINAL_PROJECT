package com.team.prj.seller.service;

import java.util.List;

public interface SellerService {
	List<SellerVO> sellerSelectList();
	
	SellerVO sellerSelect(SellerVO vo);
	
	int sellerInsert(SellerVO vo);
	
	
}
