package com.sist.dao;

public class MaDAO {
	// getConnection
	//========================================= �������� ���Ǵ� �κ� (AOP ���)
	public void getConnection() {
		System.out.println("����Ŭ ����");
	}
	// disConnection
	public void disConnection() {
		System.out.println("����Ŭ ����");
	}
	//=========================================
	//AOP�� OOP���� ���� ���ϴ� �ڵ� ȣ���� �����ϰ� ���� ���� : OOP�� ����
	public void select() {
		//getConnection();
		System.out.println("SELECT����ó��");
		//disConnection();
	}
	public void insert() {
		//getConnection();
		System.out.println("INSERT����ó��");
		//disConnection();
	}
	public void update() {
		//getConnection();
		System.out.println("UPDATE����ó��");
		//disConnection();
	}
	public void delete() {
		//getConnection();
		System.out.println("DELETE����ó��");
		//disConnection();
	}
	public String find(String fd) {
		return fd+"ã��Ϸ� ^~^ ";
	}
	
	
}
