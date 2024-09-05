package com.sist.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;

public interface MusicMapper {
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music ORDER BY mno ASC")
	public List<MusicVO> musicListData();
	
//	@Select("SELECT mno,title,singer,album,idcrement,state "
//			+ "FROM genie_music "
//			+ "WHERE ${column} LIKE '%'||#{find}||'%'")
//	public List<MusicVO> musicFind(@Param("column")String column,@Param("find") String find);
	
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+ "FROM genie_music "
			+ "WHERE ${column} LIKE '%'||#{find}||'%'")
	public List<MusicVO> musicFind(Map map);
	
	
	
	
}
