package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String board_list(String page,Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<BoardVO> list=dao.boardListData(start, end);
		int total=dao.boardTotal();
		
		int totalpage=(int)(Math.ceil(total/12.0));
				
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("count",total);
		model.addAttribute("total",totalpage);
		
		return "board/list";
	}
	
	@GetMapping("board/insert.do")
	public String board_insert() {
		return "board/insert";
	}
	//@responsebody
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) { // 커맨드 객체 => VO단위로 값을 받는 경우
		dao.boardInsert(vo);
		
		// 비밀번호 암호화
		
		
		return "redirect:list.do";
	}
}
