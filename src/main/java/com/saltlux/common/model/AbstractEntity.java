/**
 * 
 */
package com.saltlux.common.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author SONDN
 *
 */
@MappedSuperclass
public abstract class AbstractEntity<I extends Serializable> implements BasicEntity<I> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5249609026891565697L;
	
	/**
	 * ID of Object
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public I id;

	public void setId(I id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.saltlux.common.model.BasicEntity#getId()
	 */
	@Override
	public I getId() {
		return id;
	}
}
