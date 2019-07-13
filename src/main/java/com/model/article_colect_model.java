package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.admin_Dto;
import com.dto.article_Dto;
import com.dto.article_colect_Dto;

import util.DButil;

/*
 * 文章收集表相关方法
 */
public class article_colect_model {
	//1.通过useerid查询 返回一个article_colect的Dto
	public article_colect_Dto QueryByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		article_colect_Dto dto = new article_colect_Dto();
		try {
			String sql = "select * from article_colect where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setCol_time(rs.getString("col_time"));
				dto.setUncol_time(rs.getString("uncol_time"));
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
	// 2.从数据库导入数据(全查找article_colect信息)
	public List<article_colect_Dto> find_article_colect() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_colect_Dto> list = new ArrayList<article_colect_Dto>();
		try {
			String sql = "select * from article_colect";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				article_colect_Dto dto = new article_colect_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setCol_time(rs.getString("col_time"));
				dto.setUncol_time(rs.getString("uncol_time"));
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
	//3.插入数据到article_colect表中  传入article_colect_Dto参数
	public void add_article_colect(article_colect_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into article_colect(userid, arcid, col_time, uncol_time) values(?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getUserid());
		statement.setString(2, dto.getArcid());
		statement.setString(3, dto.getCol_time());
		statement.setString(4, dto.getUncol_time());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到article_colect表成功!");
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

	// 4.通过userid从数据库导入数据(全查找article_colect信息)
	public List<article_colect_Dto> find_article_colect_DtoByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_colect_Dto> list = new ArrayList<article_colect_Dto>();
		try {
			String sql = "select * from article_colect where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				article_colect_Dto dto = new article_colect_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setCol_time(rs.getString("col_time"));
				dto.setUncol_time(rs.getString("uncol_time"));
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
}
