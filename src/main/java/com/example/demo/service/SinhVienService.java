package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SinhVienDTO; 
import com.example.demo.model.SinhVien;
public interface SinhVienService {
	SinhVien saveSinhVien(SinhVien sinhvien);
	void deleteSinhVienById(long id);
	SinhVien updateSinhVien(SinhVien sinhvien,long id);
	List<SinhVien> findAllSinhVien();
	SinhVien findSinhVienById(long id);
	SinhVien convertDTOToEntity(SinhVienDTO sinhviendto);
	SinhVienDTO convertEntityToDTO(SinhVien sinhvien);
}
