package com.example.demo.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;


@Data
public class SinhVienDTO {
	
	@NotNull
	private int id;
	
	@NotEmpty(message="Ten lop không được trống")
	@Size(min = 2)
	private String name;
	
	@NotEmpty(message="Phải nhập địa chỉ email")
	@Email(message= "Phải nhập đúng địa chỉ email")
	private String email;

	@Length(min=8, max=32, message="mật khẩu phải dài 8-32 ký tự")
	private String password;
	
	private String confirmPassword;
	
	@NotEmpty(message="Địa chỉ không được trống")
	private String diaChi;
}