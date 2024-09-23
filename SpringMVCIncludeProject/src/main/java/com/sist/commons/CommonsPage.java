package com.sist.commons;
import java.util.*;

public class CommonsPage {
	public  static Map pageConfig(String page,int rowSize) {
		if(page==null)
	    	page="1";
	    int curpage=Integer.parseInt(page);
	    Map map=new HashMap();
	    map.put("start", (curpage*rowSize)-(rowSize-1));
	    map.put("end", curpage*rowSize);
	    
	    return map;
	}
}
