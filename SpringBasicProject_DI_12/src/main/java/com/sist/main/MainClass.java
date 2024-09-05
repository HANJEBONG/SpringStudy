package com.sist.main;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		FoodDAO dao=(FoodDAO)app.getBean("dao");
		Scanner scan=new Scanner(System.in);
		System.out.println("페이지 입력:");
		int page=scan.nextInt();
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<FoodVO> list=dao.foodListData(start, end);
		for(FoodVO vo:list) {
			System.out.println(vo.getFno());
			System.out.println(vo.getName());
			System.out.println(vo.getAddress());
			System.out.println(vo.getPhone());
			System.out.println(vo.getScore());
			System.out.println("=====================");
		}
	}

}
