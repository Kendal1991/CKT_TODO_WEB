package com.ckt.ckttodo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ckt.ckttodo.pojo.User;

@Repository
public interface IUserDao {
	
	List<User> getUserList();
	User getUserByAccount(String account);
}
