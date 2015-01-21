package com.bluesky.rest.data.pdo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prefix database table.
 * 
 */
@Entity
@Table(name="prefix")
@NamedQuery(name="Prefix.findAll", query="SELECT p FROM Prefix p")
public class Prefix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prefix_id", unique=true, nullable=false)
	private int prefixId;

	@Column(nullable=false, length=5)
	private String prefixName;

	public Prefix() {
	}

	public int getPrefixId() {
		return this.prefixId;
	}

	public void setPrefixId(int prefixId) {
		this.prefixId = prefixId;
	}

	public String getPrefixName() {
		return this.prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

}