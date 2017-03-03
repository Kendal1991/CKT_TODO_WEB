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

import com.ckt.ckttodo.dao.IUserDao;
import com.ckt.ckttodo.pojo.User;
import com.ckt.ckttodo.service.IUserService;

/**
 * @ClassName UserServiceImpl
 * @author yuan
 * @date 2016��6��23��
 * @version 1.0
 */
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	/**
	 * <p>Title: getUserList</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.ckt.ckttodo.service.IUserService#getUserList() 
	*/
	@Override
	public List<User> getUserList() {
		return this.userDao.getUserList();
	}
	/** (non Javadoc) 
	 * <p>Title: getUserByAccount</p> 
	 * <p>Description: </p> 
	 * @param account
	 * @return 
	 * @see com.ckt.ckttodo.service.IUserService#getUserByAccount(java.lang.String) 
	*/
	
	@Override
	public User getUserByAccount(String account) {
		return this.userDao.getUserByAccount(account);
	}

}
