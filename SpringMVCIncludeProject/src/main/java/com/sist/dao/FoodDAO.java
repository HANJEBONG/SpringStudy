package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	/*
	 * @Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT + INDEX_ASC(food_house fh_fno_pk)fno,name,poster "
			+ "FROM food_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodListData(Map map);
	
		@Select("SELECT COUNT(*) FROM food_house")
		public int foodTotalData();
	 */
	public List<FoodVO> foodListData(Map map){
		return mapper.foodListData(map);
	}
	
	public int foodTotalData() {
		return mapper.foodTotalData();
	}
	public FoodVO foodCookieData(int fno) {
		return mapper.foodCookieData(fno);
	}
	

	
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	public List<FoodVO> foodTop5Data(){
		return mapper.foodTop5Data();
	}
}
