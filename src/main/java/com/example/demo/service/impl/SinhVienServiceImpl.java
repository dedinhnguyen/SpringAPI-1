package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundExeption;
import com.example.demo.model.SinhVien;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.service.SinhVienService;

@Service
public class SinhVienServiceImpl implements SinhVienService{
		
	@Autowired
	private SinhVienRepository sinhVienRepository;
		


	@Override
	public SinhVien saveSinhVien(SinhVien sinhvien){
		return sinhVienRepository.save(sinhvien);
	}


	@Override
	public SinhVien updateSinhVien(SinhVien sinhvien,long id) {
		SinhVien exitingSinhvien = sinhVienRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc", "Id", id));
		exitingSinhvien.setName(sinhvien.getName());
		sinhVienRepository.save(exitingSinhvien);
		return exitingSinhvien;
	}


	@Override
	public List<SinhVien> findAllSinhVien(){
		return sinhVienRepository.findAll();
	}


	@Override
	public SinhVien findSinhVienById(long id) {
		return sinhVienRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc","Id", id));
	}


	@Override
	public void deleteSinhVienById(long id) {
		sinhVienRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Sinhvien","Id", id));
		sinhVienRepository.deleteById(id);
	}
}
