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

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		member.setMem_name(request.getParameter("name"));
		member.setMem_password(request.getParameter("pwd"));
		member.setMem_email(request.getParameter("email"));
		member.setMem_level(request.getParameter("level"));
		request.getParameter("token");
		Writer out = response.getWriter();
		String resource = "configuration.xml";
		InputStream is = LoginServlet.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		MemberMapper memberMapper = session.getMapper(MemberMapper.class);
//		String result =
				memberMapper.insertMember(member);
//		if (result.equals("1")) {
			out.write("true");
//		} else {
//			out.write("false");
//		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req,resp);
	}
}