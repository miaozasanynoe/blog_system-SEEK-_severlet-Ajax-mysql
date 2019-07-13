package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.notice_Dto;
import com.dto.user_Dto;
import com.dto.watched_Dto;

import util.DButil;

public class watched_model {
	//1.通过wauser_id查询 返回一个watched的Dto
	public watched_Dto QueryByWauserId(String wa_userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		watched_Dto dto = new watched_Dto();
		try {
			String sql = "select * from watched where wa_userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wa_userid);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setWa_userid(rs.getString("wa_userid"));
				dto.setWa_time(rs.getString("wa_time"));
				dto.setWing_userid(rs.getString("wing_userid"));
				dto.setUnwa_time(rs.getString("unwa_time"));
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
	// 2.从数据库导入数据(全查找watched信息)
	public List<watched_Dto> find_watched_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<watched_Dto> list = new ArrayList<watched_Dto>();
		try {
			String sql = "select * from watched";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				watched_Dto dto = new watched_Dto();
				dto.setWa_userid(rs.getString("wa_userid"));
				dto.setWa_time(rs.getString("wa_time"));
				dto.setWing_userid(rs.getString("wing_userid"));
				dto.setUnwa_time(rs.getString("unwa_time"));
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
	//3.插入数据到watched表中  传入watched_Dto参数
	public void add_watched(watched_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into watched(wa_userid, wa_time, wing_userid,unwa_time) values(?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getWa_userid());
		statement.setString(2, dto.getWa_time());
		statement.setString(3, dto.getWing_userid());
		statement.setString(4, dto.getUnwa_time());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到watched表成功!");
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
