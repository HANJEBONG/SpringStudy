package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class RecipeServiceImp1 implements RecipeService{
	@Autowired
	private RecipeDAO dao;

	@Override
	public List<RecipeVO> recipeListData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeListData(map);
	}

	@Override
	public int recipeRowCount() {
		// TODO Auto-generated method stub
		return dao.recipeRowCount();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.recipeDetailData(no);
	}

	@Override
	public List<ChefVO> chefListData(Map map) {
		// TODO Auto-generated method stub
		return dao.chefListData(map);
	}

	@Override
	public int chefTotalPage() {
		// TODO Auto-generated method stub
		return dao.chefTotalPage();
	}

	@Override
	public List<RecipeVO> chefMakeRecipeData(Map map) {
		// TODO Auto-generated method stub
		return dao.chefMakeRecipeData(map);
	}

	@Override
	public int chefMakeRecipeTotalPage(String chef) {
		// TODO Auto-generated method stub
		return dao.chefMakeRecipeTotalPage(chef);
	}

	@Override
	public RecipeVO cookieData(int no) {
		// TODO Auto-generated method stub
		return dao.cookieData(no);
	}

	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(String find) {
		// TODO Auto-generated method stub
		return dao.recipeFindTotalPage(find);
	}

	@Override
	public List<RecipeVO> recipeTop5Data() {
		// TODO Auto-generated method stub
		return dao.recipeTop5Data();
	}
}
