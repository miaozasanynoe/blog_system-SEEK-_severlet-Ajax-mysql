package com.test;

import java.util.List;

import com.dto.notice_Dto;
import com.dto.user_feedback_Dto;
import com.model.notice_model;
import com.model.user_feedback_model;

public class user_feedback_test {

	public static void main(String[] args) {
		/*测试查询功能
		user_feedback_model user_feedback=new user_feedback_model();
		user_feedback_Dto dto=new user_feedback_Dto();
		dto=user_feedback.QueryByUserId("201701020124");
		System.out.println(dto.getFeedtext());*/
		/*测试插入功能*/
		user_feedback_model user_feedback=new user_feedback_model();
		user_feedback_Dto dto=new user_feedback_Dto();
		dto.setUserid("201701020135");
		dto.setTime("2019/7/6");
		dto.setType("xxx");
		dto.setFeedtext("xxx");
		dto.setId("201902");
		user_feedback.add_user_feedback(dto);
		/*测试全查询功能*/
		
		List<user_feedback_Dto> list=user_feedback.find_user_feedback_Dto();
		 for(user_feedback_Dto arr:list)
		 {
			 System.out.println(arr.getFeedtext()+" "+arr.getType()+" "+arr.getId()+" ");
		 }

	}

}
