package com.ckt.ckttodo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ckt.ckttodo.pojo.Member;

@Repository
public interface IMemberDao {
	
	List<Member> getMemberList();
	Member getMemberByMemName(String mem_name);
}
