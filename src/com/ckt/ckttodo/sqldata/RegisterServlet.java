package com.ckt.ckttodo.sqldata;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		String email = request.getParameter("email");
		String level = request.getParameter("level");
		String token = request.getParameter("token");
		System.out.println(username + ":" + password);
		Writer out = response.getWriter();
		long time = System.currentTimeMillis();
		String result = new GetSqlData().insertData(username, password,email,Integer.parseInt(level),token,time);
		if (result.equals("1")) {
			out.write("true");
		} else {
			out.write("false");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req,resp);
	}
}