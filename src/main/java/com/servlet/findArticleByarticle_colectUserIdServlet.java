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
import com.dto.article_Dto;
import com.dto.article_colect_Dto;
import com.model.article_colect_model;
import com.model.article_model;

/**
 * Servlet implementation class findArticleByarticle_colectUserIdServlet
 */
@WebServlet("/findArticleByarticle_colectUserIdServlet")
public class findArticleByarticle_colectUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findArticleByarticle_colectUserIdServlet() {
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
		String article_colectInfo = request.getParameter("findArticleByarticle_colectUserIdServlet"); //从前端获取数据first
		/*ycy*/
		JSONObject jsonObject = JSONObject.parseObject(article_colectInfo);
		article_colect_Dto article_colect = jsonObject.toJavaObject(article_colect_Dto.class);
		article_model artm=new article_model();
		List<article_Dto> list =artm.find_articleByArcIdFromArticle_Colect(article_colect);
		//将list转换为json数组
		JSONArray jsonList = JSONArray.parseArray(JSON.toJSONString(list));	
		String jsonStr=jsonList.toString();
		System.out.print("str:::::::::::::::::::s"+jsonStr);
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
