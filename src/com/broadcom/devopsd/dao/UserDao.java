package com.broadcom.devopsd.dao;

import com.broadcom.devopsd.entity.User;

public interface UserDao {
	User findByUserName(String username);
}
