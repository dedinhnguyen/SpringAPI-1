package com.example.demo.dto;

import com.example.demo.model.SinhVien;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienDTO {
	
	private long id;
	private String name;
	
	public SinhVienDTO(SinhVien original){
		this.id = original.getId();
       this.name= original.getName();
    }
}