package com.saltlux.common.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.saltlux.common.constant.TBLConstant;

@Entity
@Table(name = TBLConstant.TBL_USER, 
	uniqueConstraints = @UniqueConstraint(columnNames = { TBLConstant.TBL_USER_USERNAME }))
public class User extends NumericIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4277251873257785302L;

	/**
	 * User Password
	 */

	@Column(name = TBLConstant.TBL_USER_PASSWORD)
	private String password;

	/**
	 * Username
	 */
	@Column(name = TBLConstant.TBL_USER_USERNAME)
	private String username;

	/**
	 * Firstname of the user
	 */
	@Column(name = TBLConstant.TBL_USER_FIRSTNAME)
	private String firstname;

	/**
	 * Lastname of the user
	 */
	@Column(name = TBLConstant.TBL_USER_LASTNAME)
	private String lastname;

	/**
	 * Email ID
	 */
	@Column(name = TBLConstant.TBL_USER_EMAIL)
	private String email;

	/**
	 * Account enabled
	 */
	@Column(name = TBLConstant.TBL_USER_ENABLED)
	private short enabled;

	@OneToMany(mappedBy = TBLConstant.TBL_USER_MAP)
	private List<Authority> authorities;

	public User() {
		// For hibernate
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * Checking whether user account is enabled
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		return enabled == 1 ? true : false;
	}
}
