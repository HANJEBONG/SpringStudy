package com.sist.vo;

import lombok.Data;

/*
 * NO	NUMBER(38,0)	No		1	
GOODS_NAME	VARCHAR2(4000 BYTE)	Yes		2	
GOODS_SUB	VARCHAR2(4000 BYTE)	Yes		3	
GOODS_PRICE	VARCHAR2(26 BYTE)	Yes		4	
GOODS_DISCOUNT	NUMBER(38,0)	Yes		5	
GOODS_FIRST_PRICE	VARCHAR2(26 BYTE)	Yes		6	
GOODS_DELIVERY	VARCHAR2(26 BYTE)	Yes		7	
GOODS_POSTER	VARCHAR2(4000 BYTE)	Yes		8	
HIT	NUMBER(38,0)	Yes		9	
 */
@Data
public class GoodsVO {
	private int no,goods_discount,hit;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery;
}
