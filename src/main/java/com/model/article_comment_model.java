package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.article_colect_Dto;
import com.dto.article_comment_Dto;

import util.DButil;

public class article_comment_model {
	//1.通过arcticle_id查询 返回一个article_comment的Dto
	public article_comment_Dto QueryByArcticleId(String arcticle_id) {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		article_comment_Dto dto = new article_comment_Dto();
		try {
			String sql = "select * from article_comment where arcticle_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, arcticle_id);
			rs = pstmt.executeQuery();// 执行SQL语句
			if (rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setArcticle_id(rs.getString("arcticle_id"));
				dto.setReback_arctcle_id(rs.getString("reback_arctcle_id"));
				dto.setTime(rs.getString("time"));
				dto.setComment_id(rs.getString("comment_id"));
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
	// 2.从数据库导入数据(全查找article_comment信息)
	public List<article_comment_Dto> find_article_comment_Dto() {
		DButil db = new DButil();
		Connection con = db.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		List<article_comment_Dto> list = new ArrayList<article_comment_Dto>();
		try {
			String sql = "select * from article_comment";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 执行SQL语句
			while (rs.next()) {
				article_comment_Dto dto = new article_comment_Dto();
				dto.setUser_id(rs.getString("user_id"));
				dto.setArcticle_id(rs.getString("arcticle_id"));
				dto.setReback_arctcle_id(rs.getString("reback_arctcle_id"));
				dto.setTime(rs.getString("time"));
				dto.setComment_id(rs.getString("comment_id"));
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
	//3.插入数据到article_comment表中  传入article_comment_Dto参数
	public void add_article_comment(article_comment_Dto dto)
    {
	 	DButil db = new DButil();
    	Connection conn = db.getConnection();
		PreparedStatement statement = null;
	try {
    	String sql="insert into article_comment(arcticle_id, user_id, reback_arctcle_id, time, comment_id) values(?,?,?,?,?)";
		statement = conn.prepareStatement(sql);
		statement.setString(1, dto.getArcticle_id());
		statement.setString(2, dto.getUser_id());
		statement.setString(3, dto.getReback_arctcle_id());
		statement.setString(4, dto.getTime());
		statement.setString(5, dto.getComment_id());
		int result=statement.executeUpdate();
		if(result>0)
		{
			System.out.println("插入到article_comment表成功!");
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
