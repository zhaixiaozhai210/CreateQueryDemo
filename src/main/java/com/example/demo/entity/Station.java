package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 厂商
 *
 * @author mike
 */
@Entity
@Table(name = "rec_station")
public class Station implements Serializable {

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(length = 32,name = "s_id")
	private String id;

	private static final long serialVersionUID = 1L;

	/**
	 * 厂商名称
	 */
	@Column(length = 100,name = "s_name")
	private String name;

	/**
	 * 信用编码
	 */
	@Column(length = 50,name = "s_credit")
	private String credit;

	/**
	 * 厂商简称
	 */
	@Column(length = 50,name = "s_abbreviation")
	private String abbreviation;

	/**
	 * 地址
	 */
	@Column(name = "s_address")
	private String address;

	/**
	 * 联系人
	 */
	@Column(length = 50,name = "s_contact_person")
	private String contactPerson;

	/**
	 * 联系电话
	 */
	@Column(length = 50,name = "s_contact_phone")
	private String contactPhone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
