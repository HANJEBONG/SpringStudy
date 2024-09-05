package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// HandlerMapping => @Controller : DispatcherServlet연결
// 요청을 받아서 => 데이터베이스 연동 => JSP 결과값 전송 ==> Model
// 전체 프로그램의 조립기 (main)
/*
 * 	요청 => 요청 분리 (구분)
 * 		   @RequestMapping =============> POST/GET 동시에 처리 => 검색 (PostMapping)
 * 																| => <form>
 * 															  페이지 나누기 (GetMapping) <a>
 * 				==================== Spring 6에서 제거
 *           = @GetMapping
 *           = @PostMapping
 *        -----------------------------------------------------------
 *     => 요청하는 데이터
 *        사용자가 보내준 데이터
 *          예) 상세보기 => (번호)
 *              로그인 => id,pwd
 *              검색 => 검색어
 *              목록 => 페이지
 *              ======================== getParameter() ===> 매개변수
 *     => 요청결과 전송 : Model (전송객체를 이용)
 *        -----------------------------------------------------------
 *        
 *     JSP => 요청
 *            === <a> , <form> => .do
 *     Controller
 *       => @GetMapping(".do")
 *     Mapper => SQL문장
 *     DAO => SQL 구현
 *     -----------------------
 *     Controller
 *       => DAO 호출
 *       => Model에 담기
 *     JSP : 출력
 */
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.sist.service.RecipeServiceImp1;
@Controller
public class MainController {
	@Autowired
	private RecipeServiceImp1 rService;
	
	@GetMapping("main/main.do")
	public String main_main(String page,Model model,HttpServletRequest request) {
			if(page==null)
		    	page="1";
		    int curpage=Integer.parseInt(page);
		    Map map=new HashMap();
		    map.put("start", (curpage*20)-19);
		    map.put("end", curpage*20);
		    List<RecipeVO> list=rService.recipeListData(map);
		    int count=rService.recipeRowCount();
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
		    List<RecipeVO> cList=new ArrayList<RecipeVO>();
		    if(cookies!=null) {
		    	// 최신부터 담는다
			    for(int i=cookies.length-1;i>=0;i--) {
			    	if(cookies[i].getName().startsWith("recipe_")) {
			    		String no=cookies[i].getValue();
			    		RecipeVO vo=rService.cookieData(Integer.parseInt(no));
			    		cList.add(vo);
			    	}	
			    }
		    	
		    }
		    model.addAttribute("size", cList.size());
		    model.addAttribute("cList", cList);
		    model.addAttribute("main_jsp","../main/home.jsp");
		    return "main/main";
	}
}
