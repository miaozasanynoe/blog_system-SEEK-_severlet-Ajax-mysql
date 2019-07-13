package com.test;

import java.util.List;

import com.dto.article_colect_Dto;
import com.dto.article_comment_Dto;
import com.model.article_colect_model;
import com.model.article_comment_model;

public class article_comment_test {

	public static void main(String[] args) {
		/*测试查询功能
		article_comment_model article_comment=new article_comment_model();
		article_comment_Dto dto=new article_comment_Dto();
		dto=article_comment.QueryByArcticleId("1");
		System.out.println(dto.getComment_id());*/
		/*测试插入功能*/
		article_comment_model article_comment=new article_comment_model();
		article_comment_Dto dto=new article_comment_Dto();
		dto.setArcticle_id("2");
		dto.setUser_id("201701020135");
		dto.setReback_arctcle_id("1");
		dto.setTime("2019/7/6");
		dto.setComment_id("3");
		article_comment.add_article_comment(dto);
		/*测试全查询功能*/
		
		List<article_comment_Dto> list=article_comment.find_article_comment_Dto();
		for(article_comment_Dto arr:list)
		{
			System.out.println(arr.getArcticle_id()+" "+arr.getUser_id()+" "+arr.getReback_arctcle_id()+" ");
		}

	}

}
