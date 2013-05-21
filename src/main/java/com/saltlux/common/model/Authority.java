/**
 * 
 */
package com.saltlux.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.saltlux.common.constant.TBLConstant;

/**
 * @author SONDN
 *
 */
@Entity
@Table(name = TBLConstant.TBL_AUTHORITY)
public class Authority extends NumericIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 473249742903695172L;

	/**
	 * Authority name
	 */
	@Column(name = TBLConstant.TBL_AUTHORITY_AUTHORITY)
	private String authority; 
	
	/**
	 * Bi-directional many-to-one association to User
	 */
	@ManyToOne
	private User user;
	
	
	public Authority() {
		// For hibernate
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
