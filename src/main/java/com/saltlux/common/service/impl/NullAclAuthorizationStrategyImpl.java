/**
 * 
 */
package com.saltlux.common.service.impl;

import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.model.Acl;

/**
 * @author SONDN
 *
 */
public class NullAclAuthorizationStrategyImpl implements AclAuthorizationStrategy {

	/* (non-Javadoc)
	 * @see org.springframework.security.acls.domain.AclAuthorizationStrategy#securityCheck(org.springframework.security.acls.model.Acl, int)
	 */
	@Override
	public void securityCheck(Acl acl, int changeType) {

	}
}
