package com.team.prj.goods.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsVO {
	private int goodsNo, amount, price, hit, sellerNo, dc, groupNo;
	private String name, category, info, uploadState, sellState, categoryId, returnMessage;
	private Date uploadDate;
}
