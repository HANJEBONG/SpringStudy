package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BoardMapper {
	// 목록
	@Select("SELECT no,subject,name,TO_CHAR(regdate, 'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM spring_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM spring_board")
	public int boardTotal();
	
	// 추가
	@Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
			+ "VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
	// 상세보기
	// 수정
	// 삭제
	// 검색
}
