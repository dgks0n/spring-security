package com.saltlux.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.saltlux.common.dao.UserDao;
import com.saltlux.common.model.User;

@Repository
public class UserDaoImpl extends BaseGenericDAOImpl<User, Long> implements UserDao {
	
}