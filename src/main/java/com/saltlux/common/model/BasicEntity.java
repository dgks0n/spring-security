/**
 * 
 */
package com.saltlux.common.model;

import java.io.Serializable;

/**
 * @author SONDN
 *
 */
public interface BasicEntity<I extends Serializable> extends Serializable {

	/**
	 * Get Id
	 * 
	 * @return
	 */
	public I getId();
}
