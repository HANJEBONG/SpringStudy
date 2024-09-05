package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
@RequestMapping("food/")
public class FoodController {
	//필요한 객체 => DAO
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("list.do")
	public String food_list(String page,Model model) {
		// Model => 전송 객체 (request 대신 JSP로 값을 전송하는 클래스
		// 사용자가 보내준 값을 매개변수를 통해 값을 받는다
		// request : Cookie 사용시
		// response : Cookie or file업로드
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		final int BLOCK=10;
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
		int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		
		/*
		 *  class Model{
		 *  	public void addAttribute(String key , Object obj){
		 *  		request.setAttribute(key,obj);
		 *  	}
		 *  }
		 */
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("endpage",endpage);
		model.addAttribute("list",list);
		model.addAttribute("startpage",startpage);
		return "food/list";
	}
}
