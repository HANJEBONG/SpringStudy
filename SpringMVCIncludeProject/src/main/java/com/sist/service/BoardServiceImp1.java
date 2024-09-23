package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.BoardDAO;

@Service
public class BoardServiceImp1 implements BoardService{
	private BoardDAO dao;
	@Autowired
	public BoardServiceImp1(BoardDAO dao) {
		this.dao=dao;
	}
	
}
