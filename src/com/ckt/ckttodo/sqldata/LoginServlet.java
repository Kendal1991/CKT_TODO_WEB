package com.ckt.ckttodo.sqldata;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("mem_name");
		String password = request.getParameter("mem_pwd");

		Writer out = response.getWriter();

		String pwd = new GetSqlData().getdata(username);
		if (pwd.equals(password)) {
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