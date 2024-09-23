package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(food_house fh_fno_pk)*/fno,name,poster "
			+ "FROM food_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT COUNT(*) FROM food_house")
	public int foodTotalData();
	
	@Select("SELECT fno,name,poster "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodCookieData(int fno);
	
	@Update("UPDATE food_house SET "
			+ "hit=hit+1 "
			+ "WHERE fno=#{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT * "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	@Select("SELECT fno,name,poster,rownum "
			+ "FROM (SELECT fno,name,poster FROM food_house ORDER BY hit DESC) "
			+ "WHERE rownum <=5 ")
	public List<FoodVO> foodTop5Data();
}
