package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// �������� ���赵�� ���� => ������ �������� ��ġ
// xml => �޴���
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
