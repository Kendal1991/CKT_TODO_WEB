package com.ckt.ckttodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ckt.ckttodo.pojo.Member;
import com.ckt.ckttodo.service.IMemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private IMemberService memberService;
	
	@RequestMapping("/getMemberList")
	public String getMemberList(Model model){
		List<Member> list = this.memberService.getMemberList();
		model.addAttribute("mlist",list);
		return "member";
	}
	
}
