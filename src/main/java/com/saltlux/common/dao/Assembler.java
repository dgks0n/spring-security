package com.saltlux.common.dao;

import org.springframework.security.core.userdetails.User;

public interface Assembler {

	User buildUserFromUserEntity(com.saltlux.common.model.User user);
}
