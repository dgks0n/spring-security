/**
 * 
 */
package com.saltlux.common.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * @author SONDN
 * 
 * Extension of GenericDAOImpl that is configured for Autowiring with Spring or J2EE.
 *
 */
public class BaseGenericDAOImpl<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {

	@Override
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
