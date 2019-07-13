package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.*;
import com.dto.*;
import com.model.user_model;

/**
 * Servlet implementation class loginjg
 */
@WebServlet("/login_jg") 
public class loginjg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginjg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		user_Dto temp=new user_Dto();
		temp.setId("-1");
		String req=JSON.toJSONString(temp);
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userinfo = request.getParameter("userinfo"); //��ǰ�˻�ȡ����first
		JSONObject jsonObject = JSONObject.parseObject(userinfo);
		user_Dto user = jsonObject.toJavaObject(user_Dto.class);
		user_model usd=new user_model();
		user_Dto userdto=usd.QueryById(user.getId());
		if(userdto.getPassw().equals(user.getPassw())) {
			System.out.print("��¼�ɹ�");
			req=JSON.toJSONString(userdto);
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", req);
		}
		
		System.out.print(userinfo);
		out.print(req);///���ͻ�����������doGet�ַ���
		//out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
