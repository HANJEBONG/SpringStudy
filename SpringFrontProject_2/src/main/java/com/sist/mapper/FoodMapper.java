package com.sist.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(food_house fh_fno_pk)*/fno,name,poster "
			+ "FROM food_house)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start")int start,@Param("end")int end);
	
	@Select("SELECT COUNT(*) FROM food_house")
	public int foodTotalData();
}
