package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.service.FoodService;
import com.sist.service.RecipeService;
import com.sist.vo.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
public class CommonsFooterAOP {
	@Autowired
	private RecipeService rService;
	
	@Autowired
	private FoodService fService;
	
	@After("execution(* com.sist.web.*.*(..))")
	public void FooterData() {
		List<RecipeVO> rList=rService.recipeTop5Data();
		List<FoodVO> fList=fService.foodTop5Data();
		// 전송
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("footRList", rList);
		request.setAttribute("footFList", fList);
	}
}
