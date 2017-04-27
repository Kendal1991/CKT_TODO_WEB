package com.ckt.ckttodo.pojo;

public interface MemberMapper {
	public Member getMemberByMemName(String mem_name);
	public void insertMember(Member Member);
}
