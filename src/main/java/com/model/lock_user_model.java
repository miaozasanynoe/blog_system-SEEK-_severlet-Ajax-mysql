package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_Dto;
import com.dto.lock_user_Dto;

import util.DButil;

public class lock_user_model {
	//1.通过userid查询 返回一个lock_user的Dto
	public lock_user_Dto QueryByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		lock_user_Dto dto = new lock_user_Dto();
		try {
			String sql = "select * from lock_user where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setLocktime(rs.getString("locktime"));
				dto.setRes(rs.getString("res"));
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
	// 2.从数据库导入数据(全查找lock_user信息)
	public  List<lock_user_Dto> find_lock_user_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<lock_user_Dto> list = new ArrayList<lock_user_Dto>();
		try {
			String sql = "select * from lock_user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				lock_user_Dto dto = new lock_user_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setLocktime(rs.getString("locktime"));
				dto.setRes(rs.getString("res"));
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
	//3.插入数据到lock_user表中  传入lock_user_Dto参数
	public void add_lock_user(lock_user_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into lock_user(userid, locktime, res) values(?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getUserid());
		statement.setString(2, dto.getLocktime());
		statement.setString(3, dto.getRes());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到lock_user表成功!");
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
