package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,score,address,phone,num "
			+ "FROM (SELECT fno,name,score,address,phone,rownumm as num "
			+ "FROM (SELECT fno,name,score,address,phone "
			+ "FROM food_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start")int start,@Param("end") int end);
}
