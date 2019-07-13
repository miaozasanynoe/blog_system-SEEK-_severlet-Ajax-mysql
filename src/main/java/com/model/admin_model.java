package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_Dto;
import com.dto.user_Dto;

import util.DButil;
/*
 * 用户表相关方法
 */
public class admin_model {
	// 通过id查询 返回一个admin的Dto
	public admin_Dto QueryById(String id) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		admin_Dto dto = new admin_Dto();
		try {
			String sql = "select * from admin where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassw(rs.getString("passw"));
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

	// 2.从数据库导入数据(全查找admin信息)
	public  List<admin_Dto> find_admin_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<admin_Dto> list = new ArrayList<admin_Dto>();
		try {
			String sql = "select * from admin";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				admin_Dto dto = new admin_Dto();
				dto.setId(rs.getString("id"));
				dto.setPassw(rs.getString("passw"));
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
	//3.插入数据到admin表中  传入admin_Dto参数
	public void add_admin(admin_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into admin(id, passw) values(?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getId());
		statement.setString(2, dto.getPassw());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到admin表成功!");
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
