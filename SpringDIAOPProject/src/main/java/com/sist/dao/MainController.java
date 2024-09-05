package com.sist.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("msg", "아 빵통조림이 여기있네~");
		return "main/main";
	}
}
