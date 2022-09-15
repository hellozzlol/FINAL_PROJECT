package com.team.prj.state.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateVO {
	private int orderNo;
	private String state;
	private Date cancelDt, cancelCfDt, changeDt, changeCfDt;
}
