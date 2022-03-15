package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
@Data
@Entity
@Table(name = "lophoc")
public class LopHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name", nullable = false)

	@NotEmpty
	private String name;
	
	@OneToMany(mappedBy = "lophoc")
	  private List<SinhVien> listSinhVien;
}