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
public class LoginController {

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
	@RequestMapping("/login")
	public ModelAndView member(HttpServletRequest request,
			HttpServletResponse response, String username, String password) throws IOException {
		/*AbstractApplicationContext context = new ClassPathXmlApplicationContext("Member-conf.xml");
	    Member member = context.getBean("member", Member.class);*/
		System.out.println("login");
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
	    return null;
	}

	// 退出
	@RequestMapping("/logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
}
