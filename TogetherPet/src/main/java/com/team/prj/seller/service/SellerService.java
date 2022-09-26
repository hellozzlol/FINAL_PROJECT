package com.team.prj.seller.service;

import java.util.List;

public interface SellerService {
	List<SellerVO> sellerSelectList();

	SellerVO sellerMyPage(SellerVO vo);

	int sellerInsert(SellerVO vo);

	int sellerUpdate(SellerVO vo);

	int sellerDelete(SellerVO vo);

}
