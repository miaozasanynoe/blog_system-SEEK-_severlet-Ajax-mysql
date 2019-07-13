package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dto.article_comment_Dto;
import com.model.article_comment_model;

/**
 * Servlet implementation class article_commentFindByArcticleIdServlet
 */
@WebServlet("/article_comment_Servlet") 
public class article_commentFindByArcticleIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public article_commentFindByArcticleIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String article_commentInfo = request.getParameter("articlecommentInfo"); //从前端获取数据first
		/*ycy*/
		System.out.print(article_commentInfo);
		JSONObject jsonObject = JSONObject.parseObject(article_commentInfo);
		System.out.print(jsonObject.getString("arcid"));
		article_comment_Dto article_comment = jsonObject.toJavaObject(article_comment_Dto.class);
		article_comment.setArcticle_id(jsonObject.getString("arcid"));
		article_comment_model artc=new article_comment_model();
		List<article_comment_Dto> list =artc.find_QueryByArcticleId(article_comment.getArcticle_id());
		//将list转换为json数组
		JSONArray jsonList = JSONArray.parseArray(JSON.toJSONString(list));
		System.out.println(jsonList);
		String jsonStr = jsonList.toString();
		out.print(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
