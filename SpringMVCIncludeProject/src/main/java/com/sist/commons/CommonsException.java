package com.sist.commons;

import java.sql.SQLException;
import java.io.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex) {
		System.out.println("====== 데이터베이스 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("===============================");
	}
	@ExceptionHandler(IOException.class)
	public void IOException(IOException ex) {
		System.out.println("====== 파일 입출력 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("===============================");
	}
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex) {
		System.out.println("====== 런타임 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("===============================");
	}
	@ExceptionHandler(Exception.class)
	public void Exception(Exception ex) {
		System.out.println("====== 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("===============================");
	}
}
