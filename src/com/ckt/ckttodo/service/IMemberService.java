package com.ckt.ckttodo.service;

import java.util.List;

import com.ckt.ckttodo.pojo.Member;

public interface IMemberService {

	List<Member> getMemberList();
	Member getMemberByMemName(String mem_name);
}
