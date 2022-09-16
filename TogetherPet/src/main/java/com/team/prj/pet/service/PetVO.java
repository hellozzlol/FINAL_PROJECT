package com.team.prj.pet.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetVO {
	int petNo;
	String type;
	String name;
	String breed;
	String weight;
	String gender;
	Date birth;
	String neu;
	int groupNo;
	int userNo;
}
