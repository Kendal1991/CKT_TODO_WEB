package com.ckt.ckttodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ckt.ckttodo.pojo.User;
import com.ckt.ckttodo.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/getUserList")
	public String getUserList(Model model){
		List<User> list = this.userService.getUserList();
		model.addAttribute("ulist",list);
		return "user";
	}
	
}
