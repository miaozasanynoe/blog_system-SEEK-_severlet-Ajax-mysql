package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//配置servlet的访问地址
//1.在web.xml配置
//2 用注解  @WebServlet("/userServlet")  -->  web.xml  
	/**用注解  @WebServlet("/userServlet")相当于在web.xml中的以下配置
		 * <servlet>
			<servlet-name>UserServlet</servlet-name>
			<servlet-class>com.servlet.UserServlet</servlet-class>
		</servlet>
		<servlet-mapping>
			<servlet-name>UserServlet</servlet-name>
			<url-pattern>/userServlet</url-pattern>
		</servlet-mapping>
	 * @author Administrator
	 *
	 */
@WebServlet("/userServlet") 
public class UserServlet extends HttpServlet {
	
	//重写doGet,doPost方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("收到doGet请求");
		PrintWriter out  =  resp.getWriter();//out
		out.print("doGet");///往客户端浏览器输出doGet字符串
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a = 10/0;
		System.out.println("收到doPost请求");
		PrintWriter out  =  resp.getWriter();//out
		out.print("doPost");///往客户端浏览器输出doGet字符串
	}

}
