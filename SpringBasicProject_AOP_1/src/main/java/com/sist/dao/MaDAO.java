package com.sist.dao;

public class MaDAO {
	// getConnection
	//========================================= 공통으로 사용되는 부분 (AOP 대상)
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	// disConnection
	public void disConnection() {
		System.out.println("오라클 해제");
	}
	//=========================================
	//AOP는 OOP에서 하지 못하는 자동 호출이 가능하게 만든 상태 : OOP를 보완
	public void select() {
		//getConnection();
		System.out.println("SELECT문장처리");
		//disConnection();
	}
	public void insert() {
		//getConnection();
		System.out.println("INSERT문장처리");
		//disConnection();
	}
	public void update() {
		//getConnection();
		System.out.println("UPDATE문장처리");
		//disConnection();
	}
	public void delete() {
		//getConnection();
		System.out.println("DELETE문장처리");
		//disConnection();
	}
	public String find(String fd) {
		return fd+"찾기완료 ^~^ ";
	}
	
	
}
