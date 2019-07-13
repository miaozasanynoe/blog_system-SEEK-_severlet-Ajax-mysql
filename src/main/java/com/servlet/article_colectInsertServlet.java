package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dto.article_colect_Dto;
import com.model.article_colect_model;

/**
 * Servlet implementation class article_colectInsertServlet
 */
@WebServlet("/article_colectInsertServlet") 
public class article_colectInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public article_colectInsertServlet() {
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
		String article_commentInfo = request.getParameter("likearticleInfo"); //从前端获取数据first
		/*ycy*/
		JSONObject jsonObject = JSONObject.parseObject(article_commentInfo);
		article_colect_Dto article_colect = jsonObject.toJavaObject(article_colect_Dto.class);
		article_colect_model artc=new article_colect_model();
		artc.add_article_colect(article_colect);
		String req=JSON.toJSONString(article_colect);
		out.print(req);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
