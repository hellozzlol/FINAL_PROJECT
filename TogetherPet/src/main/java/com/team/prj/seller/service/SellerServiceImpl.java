package com.team.prj.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.prj.seller.mapper.SellerMapper;

@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	private SellerMapper map;
	
	@Override
	public List<SellerVO> sellerSelectList() {
		return map.sellerSelectList();
	}

	@Override
	public SellerVO sellerSelect(SellerVO vo) {
		return map.sellerSelect(vo);
	}

	@Override
	public int sellerInsert(SellerVO vo) {
		return map.sellerInsert(vo);
	}

	@Override
	public int sellerUpdate(SellerVO vo) {
		return map.sellerUpdate(vo);
	}

	@Override
	public int sellerDelete(SellerVO vo) {
		return map.sellerDelete(vo);
	}

}
