/**
 * 
 */
package com.saltlux.common.model;

import javax.persistence.MappedSuperclass;

/**
 * @author SONDN
 *
 */
@MappedSuperclass
public abstract class NumericIdEntity extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1689750355975370505L;

}
