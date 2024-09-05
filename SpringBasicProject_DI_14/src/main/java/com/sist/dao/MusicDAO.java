package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository("dao")
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
	
	public List<MusicVO> musicListData(){
		return mapper.musicListData();
	}
	
//	public List<MusicVO> musicFind(String column, String find){
//		return mapper.musicFind(column, find);
//	}
	
	public List<MusicVO> musicFind(Map map){
		return mapper.musicFind(map);
	}
}
