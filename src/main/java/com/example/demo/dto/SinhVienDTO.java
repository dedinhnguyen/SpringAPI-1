package com.example.demo.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class SinhVienDTO {
	
	@NotNull
	private int id;
	
	@NotEmpty
	@Size(min = 2)
	private String name;
	
}