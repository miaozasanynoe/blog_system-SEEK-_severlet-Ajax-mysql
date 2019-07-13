package com.test;

import java.util.List;

import com.dto.article_Dto;
import com.dto.user_Dto;
import com.dto.user_feedback_Dto;
import com.model.user_feedback_model;
import com.model.user_model;

public class user_test {
	public static void main(String[] args) {
		/*测试查询功能
		user_model user_model=new user_model();
		user_Dto dto=new user_Dto();
		dto=user_model.QueryById("201701020124");
		System.out.println(dto.getPassw());
		*/
		/*测试插入功能*/
		user_model user_model=new user_model();
		user_Dto dto=new user_Dto();
		dto.setId("201701020145");
		dto.setPassw("111");
		dto.setArctitles("11");
		dto.setFans("100");
		dto.setCollects("100");
		dto.setIntegral("1200");
		dto.setEmail("2903067812@qq.com");
		user_model.add_user(dto);
		/*测试全查询功能*/
		
		List<user_Dto> list=user_model.find_user_Dto();
		 for(user_Dto arr:list)
		 {
			 System.out.println(arr.getId()+" "+arr.getPassw()+" "+arr.getEmail()+" ");
		 }
	}
}
