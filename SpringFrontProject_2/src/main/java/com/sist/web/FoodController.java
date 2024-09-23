package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.*;
import java.util.*;
@Controller
public class FoodController {
	@Autowired
	private FoodDAO fDao;
	
	@GetMapping("food/list.do")
	public String food_list(String page,Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		
		List<FoodVO> list=fDao.foodListData(start, end);
		int totalpage=fDao.foodTotalData();
		
		final int BLOCK=10;
		int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endpage>totalpage)
			endpage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage );
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		
		return "food/list";
	}
	
	@GetMapping("food/list2.do")
	public String food_list2() {
		return "food/list2";
	}
}
