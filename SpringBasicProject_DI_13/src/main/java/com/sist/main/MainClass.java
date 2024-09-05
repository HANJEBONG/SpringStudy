package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.*;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		GoodsDAO dao=(GoodsDAO)app.getBean("gggg");
		
		Scanner scan=new Scanner(System.in);
		System.out.println("∆‰¿Ã¡ˆ:");
		int page=scan.nextInt();
		
		int rowsize=12;
		int start=(rowsize*page)-(rowsize-1);
		int end=rowsize*page;
		
		List<GoodsVO> list=dao.goodsListData(start, end);
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo());
			System.out.println(vo.getGoods_name());
			System.out.println(vo.getGoods_sub());
			System.out.println("=======================");
		}
	}

}
