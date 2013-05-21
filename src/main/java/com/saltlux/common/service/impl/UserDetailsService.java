package com.saltlux.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;
import com.saltlux.common.constant.TBLConstant;
import com.saltlux.common.dao.Assembler;
import com.saltlux.common.dao.UserDao;
import com.saltlux.common.model.User;
import com.saltlux.common.util.StringUtils;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private UserDao userDao;
	
	private Assembler assembler;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = null; // Init User object (default is null)
		if (StringUtils.isNotNull(username) && StringUtils.isNotEmpty(username)) {
			List<User> users = userDao.search(new Search().addFilterEqual(TBLConstant.TBL_USER_USERNAME, username));
			if (users != null && users.size() > 0)
				user = users.get(0);
		}
		
		// Throw error exception if user object still is null
		if (user == null)
			throw new UsernameNotFoundException("No such user");
		
		return assembler.buildUserFromUserEntity(user);
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setAssembler(Assembler assembler) {
		this.assembler = assembler;
	}
}
