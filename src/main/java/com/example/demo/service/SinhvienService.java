package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Sinhvien;
public interface SinhvienService {
	Sinhvien saveSinhvien(Sinhvien sinhvien);
	void DeleteSinhvienById(long id);
	Sinhvien updateSinhvien(Sinhvien sinhvien,long id);
	List<Sinhvien> getAllSinhvien();
	Sinhvien GetSinhvienById(long id);
}
