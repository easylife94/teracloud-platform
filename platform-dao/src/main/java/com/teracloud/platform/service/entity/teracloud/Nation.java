package com.teracloud.platform.service.entity.teracloud;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nation database table.
 * 
 */
@Entity
@NamedQuery(name="Nation.findAll", query="SELECT n FROM Nation n")
public class Nation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String city;

	private String code;

	private String district;

	private String parent;

	private String province;

	public Nation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}