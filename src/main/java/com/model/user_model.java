package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.user_Dto;
import com.dto.user_feedback_Dto;

import util.DButil;
/*
 * 用户表相关方法
 */
public class user_model {
	// 1.通过id查找user表 返回dto对象
	public user_Dto QueryById(String id) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		user_Dto dto = new user_Dto();
		dto.setId("-1");
		dto.setPassw("-1");
		try {
			String sql = "select * from user where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassw(rs.getString("passw"));
				dto.setArctitles(rs.getString("arctitles"));
				dto.setFans(rs.getString("fans"));
				dto.setCollects(rs.getString("collects"));
				dto.setIntegral(rs.getString("integral"));
				dto.setEmail(rs.getString("email"));
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

	// 2.从数据库导入数据(全查找user信息)
	public List<user_Dto> find_user_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<user_Dto> list = new ArrayList<user_Dto>();
		try {
			String sql = "select * from user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				user_Dto dto = new user_Dto();
				dto.setId(rs.getString("id"));
				dto.setPassw(rs.getString("passw"));
				dto.setArctitles(rs.getString("arctitles"));
				dto.setFans(rs.getString("fans"));
				dto.setCollects(rs.getString("collects"));
				dto.setIntegral(rs.getString("integral"));
				dto.setEmail(rs.getString("email"));
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
	//3.插入数据到user表中  传入user_Dto参数
	public void add_user(user_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into user(id, passw, arctitles,fans,collects,integral,email) values(?,?,?,?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getId());
		statement.setString(2, dto.getPassw());
		statement.setString(3, dto.getArctitles());
		statement.setString(4, dto.getFans());
		statement.setString(5, dto.getCollects());
		statement.setString(6, dto.getIntegral());
		statement.setString(7, dto.getEmail());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到user表成功!");
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
