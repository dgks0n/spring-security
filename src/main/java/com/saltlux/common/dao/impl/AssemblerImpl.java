package com.saltlux.common.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.saltlux.common.dao.Assembler;
import com.saltlux.common.model.Authority;

@Repository
public class AssemblerImpl implements Assembler {

	@Override
	public User buildUserFromUserEntity(com.saltlux.common.model.User user) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Authority authority : user.getAuthorities()) {
			authorities.add(new GrantedAuthorityImpl(authority.getAuthority()));
		}
		
		User userDetails = new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	    return userDetails;
	}

}