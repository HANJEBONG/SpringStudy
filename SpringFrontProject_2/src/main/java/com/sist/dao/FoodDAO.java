package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	private FoodMapper mapper;
	
	@Autowired
	public FoodDAO(FoodMapper mapper) {
		this.mapper=mapper;
	}
	
	public List<FoodVO> foodListData(int start,int end){
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalData() {
		return mapper.foodTotalData();
	}
}
