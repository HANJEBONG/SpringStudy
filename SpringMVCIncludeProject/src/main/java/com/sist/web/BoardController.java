package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class BoardController {
	private BoardService bService;
	@Autowired
	public BoardController(BoardService bService) {
		this.bService=bService;
		List<Integer> list=new ArrayList<Integer>();
		List<String> slist=new ArrayList<String>();
		for(Integer i:list) {
			for(String v:slist) {
				
			}
		}
	}
	
}
