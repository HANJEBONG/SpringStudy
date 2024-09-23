package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 출력에 필요한 데이터 전송
// 화면 변경은 할 수 없다

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO fDao;
	
	@GetMapping(value = "food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int page) throws Exception{
		
		int rowSize=20;
		int start=(page*rowSize)-(rowSize-1);
		int end=page*rowSize;
		
		List<FoodVO> list=fDao.foodListData(start, end);
		int totalpage=fDao.foodTotalData();
		
		final int BLOCK=10;
		int startpage=((page-1)/BLOCK*BLOCK)+1;
		int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endpage>totalpage)
			endpage=totalpage;
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
		
	}

}
