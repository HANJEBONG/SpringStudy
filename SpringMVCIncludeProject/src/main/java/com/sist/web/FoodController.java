package com.sist.web;
import com.sist.vo.*;
import com.sist.service.*;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FoodController {
	@Autowired
	private FoodServiceImp1 fService;
	
	@GetMapping("food/list.do")
	public String food_list(String page,Model model,HttpServletRequest request) {
		if(page==null)
	    	page="1";
	    int curpage=Integer.parseInt(page);
	    Map map=new HashMap();
	    map.put("start", (curpage*20)-19);
	    map.put("end", curpage*20);
	    List<FoodVO> list=fService.foodListData(map);
	    int count=fService.foodTotalData();
	    
	    int totalpage=(int)(Math.ceil(count/20.0));
	    
	    final int BLOCK=10;
	    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	    
	    if(endPage>totalpage)
	    	endPage=totalpage;
	    
	    model.addAttribute("list", list);
	    model.addAttribute("count", count);
	    model.addAttribute("curpage", curpage);
	    model.addAttribute("totalpage", totalpage);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
	    Cookie[] cookies=request.getCookies();
	    List<FoodVO> cList=new ArrayList<FoodVO>();
	    if(cookies!=null) {
	    	// 최신부터 담는다
		    for(int i=cookies.length-1;i>=0;i--) {
		    	if(cookies[i].getName().startsWith("food_")) {
		    		String no=cookies[i].getValue();
		    		FoodVO vo=fService.foodCookieData(Integer.parseInt(no));
		    		cList.add(vo);
		    	}	
		    }
	    	
	    }
	    model.addAttribute("size", cList.size());
	    model.addAttribute("cList", cList);
		
		
		model.addAttribute("main_jsp","../food/list.jsp");
		return "main/main";
	}
	
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra) {
		
		Cookie cookie=new Cookie("food_"+fno,String.valueOf(fno));
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		ra.addAttribute("fno",fno);
		
		return "redirect:../food/detail.do";
	}
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model) {
		
		FoodVO vo=fService.foodDetailData(fno);
		
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp","../food/detail.jsp");
		return "main/main";
	}
	@GetMapping("food/cookie_all.do")
	   public String food_cookie_all(HttpServletRequest request,Model model)
	   {
		// 쿠키 출력 
		    Cookie[] cookies=request.getCookies();
		    List<FoodVO> cList=new ArrayList<FoodVO>();
		    // 쿠키 담는 List
		    if(cookies!=null)
		    {
		    	// 최신부터 담는다
		    	for(int i=cookies.length-1;i>=0;i--)
		    	{
		    		if(cookies[i].getName().startsWith("food_"))
		    		{
		    			String no=cookies[i].getValue();
		    			FoodVO vo=fService.foodCookieData(Integer.parseInt(no));
		    			cList.add(vo);
		    		}
		    	}
		    }
		    model.addAttribute("cList", cList);
		    model.addAttribute("size", cList.size());
		    model.addAttribute("main_jsp", "../food/cookie_all.jsp");
		    return "main/main";
	   }
	   @GetMapping("food/cookie_delete.do")
	   public String food_cookie_delete(HttpServletRequest request,HttpServletResponse response)
	   {
		   Cookie[] cookies=request.getCookies();
		   if(cookies!=null)
		   {
			   for(int i=0;i<cookies.length;i++)
			   {
				   if(cookies[i].getName().startsWith("food_"))
				   {
					   cookies[i].setPath("/");
					   cookies[i].setMaxAge(0);// 쿠키 삭제 
					   response.addCookie(cookies[i]); // 브라우저에 알림 
				   }
			   }
		   }
		   return "redirect:../food/list.do";
	   }
}
