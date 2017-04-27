package com.ckt.ckttodo.sqldata;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ckt.ckttodo.pojo.Member;
import com.ckt.ckttodo.pojo.MemberMapper;
import com.ckt.ckttodo.pojo.User;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		request.setCharacterEncoding("utf-8");
		String mem_name = request.getParameter("mem_name");
		String mem_pwd = request.getParameter("mem_pwd");

		Writer out = response.getWriter();
		String resource = "configuration.xml";
		InputStream is = LoginServlet.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		MemberMapper memberMapper = session.getMapper(MemberMapper.class);
		Member member= memberMapper.getMemberByMemName(mem_name);
		if (member != null && member.getMem_password().equals(mem_pwd)) {
			out.write("true");
		} else {
			out.write("false");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req, resp);
	}
}