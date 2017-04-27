package com.ckt.ckttodo.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ckt.ckttodo.pojo.Member;
import com.ckt.ckttodo.pojo.MemberMapper;
import com.ckt.ckttodo.sqldata.LoginServlet;

@Controller
public class RegisterController {

	/**
	 * 登录
	 * @MethodName execute 
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 * @author yuan
	 * @date 2016年6月27日 下午2:29:23
	 * @return ModelAndView
	 * @throws IOException 
	 */
	@RequestMapping("/register")
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response, String username, String password) throws IOException {
		request.setCharacterEncoding("utf-8");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Member-conf.xml");
	    Member member = context.getBean("member", Member.class);
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
	    return null;
	}

}
