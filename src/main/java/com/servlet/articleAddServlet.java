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
import com.model.article_model;

/**
 * Servlet implementation class articleAddServlet
 */
@WebServlet("/articleAddServlet1") 
public class articleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public articleAddServlet() {
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
		String watchedInfo = request.getParameter("userRegInfo_all"); //从前端获取数据first
		/*ycy*/
		JSONObject jsonObject = JSONObject.parseObject(watchedInfo);
		article_Dto dto = jsonObject.toJavaObject(article_Dto.class);
		article_model artm=new article_model();
		List<article_Dto> list =artm.find_article_Dto();
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
