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
import com.dto.watched_Dto;
import com.model.article_comment_model;
import com.model.watched_model;

/**
 * Servlet implementation class warchedAddServlet
 */
@WebServlet("/watchedAddServlet") 
public class watchedAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public watchedAddServlet() {
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
		String watchedInfo = request.getParameter("watchedInfo"); //从前端获取数据first
		/*ycy*/
		JSONObject jsonObject = JSONObject.parseObject(watchedInfo);
		watched_Dto watched = jsonObject.toJavaObject(watched_Dto.class);
		watched_model watm=new watched_model();
		watm.add_watched(watched);
		String req=JSON.toJSONString(watched);
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
