package com.team.prj.seller.mapper;

import java.util.List;

import com.team.prj.seller.service.SellerVO;

public interface SellerMapper {
	List<SellerVO> sellerSelectList();

	SellerVO sellerMyPage(SellerVO vo);

	int sellerInsert(SellerVO vo);

	int sellerUpdate(SellerVO vo);

	int sellerDelete(SellerVO vo);
}
