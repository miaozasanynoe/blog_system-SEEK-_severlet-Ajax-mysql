package com.test;

import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_colect_Dto;
import com.model.admin_model;
import com.model.article_colect_model;

public class article_colect_test {
	public static void main(String[] args) {
		/*测试查询功能
		article_colect_model article_colect=new article_colect_model();
		article_colect_Dto dto=new article_colect_Dto();
		dto=article_colect.QueryByUserId("201701020124");
		System.out.println(dto.getCol_time());*/
		/*测试插入功能*/
		article_colect_model article_colect=new article_colect_model();
		article_colect_Dto dto=new article_colect_Dto();
		dto.setUserid("201701020135");
		dto.setArcid("2");
		dto.setCol_time("2017/7/5");
		dto.setUncol_time("2019/7/5");
		article_colect.add_article_colect(dto);
		/*测试全查询功能*/
		
		List<article_colect_Dto> list=article_colect.find_article_colect();
		 for(article_colect_Dto arr:list)
		 {
			 System.out.println(arr.getUserid()+" "+arr.getArcid()+" "+arr.getUncol_time()+" ");
		 }
	}
}
