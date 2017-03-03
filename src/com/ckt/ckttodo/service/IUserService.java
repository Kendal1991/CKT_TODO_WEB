package com.ckt.ckttodo.service;

import java.util.List;

import com.ckt.ckttodo.pojo.User;

public interface IUserService {

	List<User> getUserList();
	User getUserByAccount(String account);
}
