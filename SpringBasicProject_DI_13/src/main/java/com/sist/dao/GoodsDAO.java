package com.sist.dao;
import com.sist.vo.*;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository("gggg")
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	public List<GoodsVO> goodsListData(int start,int end){
		return mapper.goodsListData(start, end);
	}
}
