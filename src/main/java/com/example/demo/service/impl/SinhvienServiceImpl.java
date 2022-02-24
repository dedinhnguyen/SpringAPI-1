package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundExeption;
import com.example.demo.model.Sinhvien;
import com.example.demo.repository.SinhvienRepository;
import com.example.demo.service.SinhvienService;

@Service
public class SinhvienServiceImpl implements SinhvienService{
		
	@Autowired
	private SinhvienRepository sinhvienrepository;
		


	@Override
	public Sinhvien saveSinhvien(Sinhvien sinhvien) {
		// TODO Auto-generated method stub
		return sinhvienrepository.save(sinhvien);
	}


	@Override
	public Sinhvien updateSinhvien(Sinhvien sinhvien,long id) {
		Sinhvien exitingSinhvien = sinhvienrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc", "Id", id));
		exitingSinhvien.setName(sinhvien.getName());
		sinhvienrepository.save(exitingSinhvien);
		return exitingSinhvien;
	}


	@Override
	public List<Sinhvien> getAllSinhvien() {
		// TODO Auto-generated method stub
		return sinhvienrepository.findAll();
	}


	@Override
	public Sinhvien GetSinhvienById(long id) {
		return sinhvienrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc","Id", id));
	}


	@Override
	public void DeleteSinhvienById(long id) {
		sinhvienrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Sinhvien","Id", id));
		sinhvienrepository.deleteById(id);
	}
}
