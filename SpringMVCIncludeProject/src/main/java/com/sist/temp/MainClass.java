package com.sist.temp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputVO ivo=new InputVO();
		ivo.setNo(2);
		ivo.setGno(13);
		ivo.setPrice(1500);
		
		StoreVO svo=new StoreVO();
		svo.setNo(1);
		svo.setGno(19);
		svo.setPrice(1900);
		
		GoodsDAO dao=new GoodsDAO();
		dao.insert(svo, ivo);
		System.out.println("정상 수행");
		
	}

}
