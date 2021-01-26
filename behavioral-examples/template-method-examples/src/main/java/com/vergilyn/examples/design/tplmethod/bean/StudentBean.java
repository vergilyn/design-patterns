package com.vergilyn.examples.design.tplmethod.bean;

import lombok.Data;

/**
 * 学生信息
 *
 * @author vergilyn
 * @date 2021-01-26
 */
@Data
public class StudentBean {
	public final static int TYPE_FORM = 1;

	public final static int TYPE_WEB = 2;

	public final static int TYPE_APP = 3;

	/**
	 * 任何条件必须
	 */
	private String name;

	/**
	 * 任何条件必须
	 */
	private int age;

	/**
	 * TYPE_FORM必须
	 */
	private Long birthday;

	/**
	 * TYPE_WEB必须
	 */
	private String hobby;

	/**
	 * TYPE_APP必须
	 */
	private String phoneNumber;

	private int registerType;

	public StudentBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
