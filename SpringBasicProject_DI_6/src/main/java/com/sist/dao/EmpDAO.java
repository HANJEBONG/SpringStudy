package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// 스프링은 관계도를 설정 => 설정한 내용으로 설치
// xml => 메뉴얼
@Repository
public class EmpDAO {
	private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
