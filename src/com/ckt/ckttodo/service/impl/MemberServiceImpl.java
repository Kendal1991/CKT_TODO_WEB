/**  
 * @Project: MySSM
 * @Title: UserServiceImpl.java
 * @Package com.myssm.yuan.service.impl
 * @author yuan
 * @date 2016��6��23�� ����3:46:48
 * @Copyright: 2016
 * @version V1.0  
*/

package com.ckt.ckttodo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ckt.ckttodo.dao.IMemberDao;
import com.ckt.ckttodo.pojo.Member;
import com.ckt.ckttodo.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{

	@Autowired
	private IMemberDao memberDao;
	/**
	 * <p>Title: getUserList</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.ckt.ckttodo.service.IUserService#getUserList() 
	*/
	@Override
	public List<Member> getMemberList() {
		return this.memberDao.getMemberList();
	}
	/** (non Javadoc) 
	 * <p>Title: getMemberByAccount</p> 
	 * <p>Description: </p> 
	 * @param account
	 * @return 
	 * @see com.ckt.ckttodo.service.IMemberService#getMemberByAccount(java.lang.String) 
	*/
	
	@Override
	public Member getMemberByMemName(String mem_name) {
		return this.memberDao.getMemberByMemName(mem_name);
	}

}
