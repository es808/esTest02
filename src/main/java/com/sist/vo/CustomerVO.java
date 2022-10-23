package com.sist.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerVO {
	private String custid;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String birth;
	private String gender;
	private String favor;
}
