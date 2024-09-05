package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_sub,num "
			+ "FROM (SELECT no,goods_name,goods_sub,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_sub "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start,@Param("end") int end);
}
