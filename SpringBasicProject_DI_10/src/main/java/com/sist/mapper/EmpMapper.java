package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
/*
 * private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
 */

import com.sist.vo.EmpVO;
public interface EmpMapper {
	@Select("SELECT empno,sal,ename,job,TO_CHER(hiredate,'YYYY-MM-DD' "
			+ "FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
}
