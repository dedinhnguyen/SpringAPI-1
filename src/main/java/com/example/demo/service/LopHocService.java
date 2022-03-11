package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LopHocDTO;
import com.example.demo.model.LopHoc;
public interface LopHocService {
	LopHoc saveLopHoc(LopHoc lophoc);
	void deleteLopHocById(long id);
	LopHoc convertDTOToEntity(LopHocDTO lophocdto);
	LopHoc updateLopHoc(LopHoc lophoc, long lopHocId);
	LopHoc findLopHocById(long lopHocId);
	List<LopHoc> findAllLopHoc();
}
