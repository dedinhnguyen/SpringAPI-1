package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name="sinhvien")
public class SinhVien {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="name", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String name;
	
	@Column(name="name", nullable=false )
	@NotEmpty(message="Phải nhập địa chỉ email")
	@Email(message= "Phải nhập đúng địa chỉ email")
	private String email;
	
	@Column(name="password", nullable = false)
	@Length(min=8, max=32, message="mật khẩu phải dài 8-32 ký tự")
	private String password;
	
	@Column(name="confirmpassword", nullable = false)
	private String confirmPassword;
	
	@NotEmpty(message="Địa chỉ không được trống")
	private String diaChi;
	@ManyToOne
	@JoinColumn(name = "lophoc_id", nullable = false)
	private LopHoc lophoc;
	}