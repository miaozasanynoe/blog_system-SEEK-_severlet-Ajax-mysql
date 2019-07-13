package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.lock_user_Dto;
import com.dto.notice_Dto;
import com.dto.user_feedback_Dto;

import util.DButil;

public class user_feedback_model {
	//1.通过userid查询 返回一个user_feedback的Dto
	public user_feedback_Dto QueryByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		user_feedback_Dto dto = new user_feedback_Dto();
		try {
			String sql = "select * from user_feedback where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setTime(rs.getString("time"));
				dto.setType(rs.getString("type"));
				dto.setFeedtext(rs.getString("feedtext"));
				dto.setId(rs.getString("id"));
			}
			// 关闭，释放资源
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	// 2.从数据库导入数据(全查找user_feedback信息)
	public  List<user_feedback_Dto> find_user_feedback_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<user_feedback_Dto> list = new ArrayList<user_feedback_Dto>();
		try {
			String sql = "select * from user_feedback";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				user_feedback_Dto dto = new user_feedback_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setTime(rs.getString("time"));
				dto.setType(rs.getString("type"));
				dto.setFeedtext(rs.getString("feedtext"));
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
			// 关闭，释放资源
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//3.插入数据到user_feedback表中  传入user_feedback_Dto参数
	public void add_user_feedback(user_feedback_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into user_feedback(userid, time, type,feedtext,id) values(?,?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getUserid());
		statement.setString(2, dto.getTime());
		statement.setString(3, dto.getType());
		statement.setString(4, dto.getFeedtext());
		statement.setString(5, dto.getId());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到user_feedback表成功!");
		}
	}
	catch(Exception e1) {
		e1.printStackTrace();
		System.out.println(e1.getMessage());
	}
	finally 
	{
		try {
			statement.close();
			conn.close();
		}
		catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
    
   }
}
