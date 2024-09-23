package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
@Service
public class FoodServiceImp1 implements FoodService{
	private FoodDAO dao;
	
	@Autowired
	public FoodServiceImp1(FoodDAO dao) {
		this.dao=dao;
	}
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodListData(map);
	}

	@Override
	public int foodTotalData() {
		// TODO Auto-generated method stub
		return dao.foodTotalData();
	}

	@Override
	public FoodVO foodCookieData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodCookieData(fno);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

	@Override
	public List<FoodVO> foodTop5Data() {
		// TODO Auto-generated method stub
		return dao.foodTop5Data();
	}

}
