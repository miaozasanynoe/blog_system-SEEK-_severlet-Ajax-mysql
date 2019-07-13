package com.test;

import java.util.List;

import com.dto.article_Dto;
import com.dto.lock_user_Dto;
import com.model.article_model;
import com.model.lock_user_model;

public class lock_user_test {

	public static void main(String[] args) {
		/*测试查询功能
		lock_user_model lock_user=new lock_user_model();
		lock_user_Dto dto=new lock_user_Dto();
		dto=lock_user.QueryByUserId("201701020124");
		System.out.println(dto.getLocktime());*/
		/*测试插入功能*/
		lock_user_model lock_user=new lock_user_model();
		lock_user_Dto dto=new lock_user_Dto();
		dto.setUserid("201701020135");
		dto.setLocktime("2019/7/6");
		dto.setRes("xxx");
		lock_user.add_lock_user(dto);
		/*测试全查询功能*/
		
		List<lock_user_Dto> list=lock_user.find_lock_user_Dto();
		 for(lock_user_Dto arr:list)
		 {
			 System.out.println(arr.getUserid()+" "+arr.getLocktime()+" "+arr.getRes()+" ");
		 }
	}

}
