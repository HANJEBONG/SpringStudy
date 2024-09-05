package com.sist.vo;

import lombok.Data;

/*
 * "SELECT fno,name,score,address,phone,num "
			+ "FROM (SELECT fno,name,score,address,phone,rownum as num "
 */
@Data
public class FoodVO {
	private int fno,score;
	private String name,address,phone,poster;
}
