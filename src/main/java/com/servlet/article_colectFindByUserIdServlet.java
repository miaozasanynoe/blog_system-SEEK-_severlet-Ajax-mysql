package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dto.article_Dto;
import com.dto.article_colect_Dto;
import com.model.article_colect_model;

/**
 * Servlet implementation class article_colectFindByUserIdServlet
 */
public class article_colectFindByUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public article_colectFindByUserIdServlet() {
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
		String article_colectInfo = request.getParameter("填入js中的变量值"); //从前端获取数据first
		/*ycy*/
		System.out.print(article_colectInfo);
		JSONObject jsonObject = JSONObject.parseObject(article_colectInfo);
		article_colect_Dto article_colect = jsonObject.toJavaObject(article_colect_Dto.class);
		article_colect_model artc=new article_colect_model();
		List<article_colect_Dto> list =artc.find_article_colect_DtoByUserId(article_colect.getUserid());
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
