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
import com.dto.user_Dto;
import com.model.user_model;

/**
 * Servlet implementation class register
 */
@WebServlet("/Register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user_Dto temp=new user_Dto();
		String req=JSON.toJSONString(temp);
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userRegInfo = request.getParameter("userRegInfo"); //从前端获取数据first
		/*ycy*/
		JSONObject jsonObject = JSONObject.parseObject(userRegInfo);
		user_Dto user = jsonObject.toJavaObject(user_Dto.class);
		user_model usd=new user_model();
		
		if(usd.QueryById(user.getId()).getId().equals("-1"))
		{
			usd.add_user(user);
			req=JSON.toJSONString(user);
			out.print(req);///往客户端浏览器输出doGet字符串
		}
		else
		{
			user.setId("-1");
			req=JSON.toJSONString(user);
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
