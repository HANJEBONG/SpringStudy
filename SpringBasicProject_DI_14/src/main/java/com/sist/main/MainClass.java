package com.sist.main;
import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.config.*;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class[] cls={MusicConfig.class,DataBaseConfig.class};
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(cls);
		
		MusicDAO dao=(MusicDAO)app.getBean("dao");
		List<MusicVO> list=dao.musicListData();
		for(MusicVO vo:list) {
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println(vo.getAlbum());
		}
		System.out.println("===============================");
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("�˻� ��� ����: ��� �˻�(1) ���� �˻�(2) �ٹ� �˻�(3)");
		int find=scan.nextInt();
		
		String[] finddata= {"","title","singer","album"};
		System.out.println(finddata[find]+"�� �����ϼ̽��ϴ�.");
		System.out.println("�˻��� �Է�:");
		String fd=scan.next();
		
		Map map=new HashMap();
		map.put("column", finddata[find]);
		map.put("find", fd);
		
		//List<MusicVO> fList=dao.musicFind(finddata[find], fd);
		
		List<MusicVO> fList=dao.musicFind(map);
		for(MusicVO vo:fList) {
			System.out.println(vo.getMno());
			System.out.println(vo.getAlbum());
			System.out.println(vo.getTitle());
			System.out.println(vo.getSinger());
		}
		
	}

}
