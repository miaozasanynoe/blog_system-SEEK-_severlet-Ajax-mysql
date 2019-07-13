package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.article_Dto;

import util.DButil;

public class article_model {
	// 1.通过arcid查找article_colect表 返回dto对象
	public article_Dto QueryByArcId(String arcid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		article_Dto dto = new article_Dto();
		try {
			String sql = "select * from article where arcid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, arcid);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setArctime(rs.getString("arctime"));
				dto.setArcatatus(rs.getString("arcatatus"));
				dto.setArchtml(rs.getString("archtml"));
				dto.setArchtml(rs.getString("title"));
				dto.setArchtml(rs.getString("content"));
				dto.setArchtml(rs.getString("imageurl"));
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

	//2.从数据库导入数据(全查找article信息)
	public List<article_Dto> find_article_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_Dto> list = new ArrayList<article_Dto>();
		try {
			String sql = "select * from article";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				article_Dto dto = new article_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setArctime(rs.getString("arctime"));
				dto.setArcatatus(rs.getString("arcatatus"));
				dto.setArchtml(rs.getString("archtml"));
				dto.setArchtml(rs.getString("title"));
				dto.setArchtml(rs.getString("content"));
				dto.setArchtml(rs.getString("imageurl"));
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
	//3.插入数据到article表中  传入article_Dto参数
	public void add_article(article_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into article( userid, arctime, arcatatus, archtml,title,content,imageurl) values(?,?,?,?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getUserid());
		statement.setString(2, dto.getArctime());
		statement.setString(3, dto.getArcatatus());
		statement.setString(4, dto.getArchtml());
		statement.setString(5, dto.getTitle());
		statement.setString(6, dto.getContent());
		statement.setString(7, dto.getImageurl());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到article表成功!");
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
	//4.通过userid从数据库导入数据(全查找article信息)
	public List<article_Dto> find_article_DtoByUserId(String userid) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_Dto> list = new ArrayList<article_Dto>();
		try {
			String sql = "select * from article where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				article_Dto dto = new article_Dto();
				dto.setUserid(rs.getString("userid"));
				dto.setArcid(rs.getString("arcid"));
				dto.setArctime(rs.getString("arctime"));
				dto.setArcatatus(rs.getString("arcatatus"));
				dto.setArchtml(rs.getString("archtml"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setImageurl(rs.getString("imageurl"));
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
