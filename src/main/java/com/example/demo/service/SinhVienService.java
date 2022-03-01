package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SinhVien;
public interface SinhVienService {
	SinhVien saveSinhVien(SinhVien sinhvien);
	void deleteSinhVienById(long id);
	SinhVien updateSinhVien(SinhVien sinhvien,long id);
	List<SinhVien> findAllSinhVien();
	SinhVien findSinhVienById(long id);
}
