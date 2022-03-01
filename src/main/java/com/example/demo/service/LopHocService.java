package com.example.demo.service;

import java.util.List;

import com.example.demo.model.LopHoc;
public interface LopHocService {
	LopHoc saveLopHoc(LopHoc lophoc);
	void deleteLopHocById(long id);
	LopHoc updateLopHoc(LopHoc lophoc,long id);
	List<LopHoc> findAllLopHoc();
	LopHoc findLopHocById(long id);
}
