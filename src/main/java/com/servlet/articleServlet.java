package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dto.article_Dto;
import com.model.article_model;

/**
 * Servlet implementation class articleServlet
 */
@WebServlet("/articleServlet") 
public class articleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public articleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		article_Dto temp=new article_Dto();
		String req=JSON.toJSONString(temp);
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String articleInfo = request.getParameter("articleInfo"); //从前端获取数据first
		/*ycy*/
		System.out.print(articleInfo);
		JSONObject jsonObject = JSONObject.parseObject(articleInfo);
		article_Dto article = jsonObject.toJavaObject(article_Dto.class);
		article_model art=new article_model();
		if(true)
		{
			art.add_article(article);
			req=JSON.toJSONString(article);
			out.print(req);///往客户端浏览器输出doGet字符串
		}
		else
		{
			article.setArcid("-1");
			req=JSON.toJSONString(article);
			out.print(req);///往客户端浏览器输出doGet字符串
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
