package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Sinhvien;
import com.example.demo.repository.SinhvienRepository;
import com.example.demo.service.SinhvienService;

@Service
public class SinhvienServiceImpl implements SinhvienService{
	
	private SinhvienRepository sinhvienrepository;
	
	
	public SinhvienServiceImpl(SinhvienRepository sinhvienrepository) {
		super();
		this.sinhvienrepository = sinhvienrepository;
	}


	@Override
	public Sinhvien saveSinhvien(Sinhvien sinhvien) {
		// TODO Auto-generated method stub
		return sinhvienrepository.save(sinhvien);
	}


	@Override
	public Sinhvien updateSinhvien(Sinhvien sinhvien,long id) {
		Optional<Sinhvien> sinhvien1= sinhvienrepository.findById(id);
		if(sinhvien1.isPresent()) {
//			sinhvien1
//			sinhvien1.setEmail(sinhvien.getEmail());
////			sinhvienrepository.save(sinhvien1);
			return sinhvien;
		}else {
			return null;
		}
	}


	@Override
	public List<Sinhvien> getAllSinhvien() {
		// TODO Auto-generated method stub
		return sinhvienrepository.findAll();
	}


	@Override
	public Sinhvien GetSinhvienById(long id) {
		Optional<Sinhvien> sinhvien = sinhvienrepository.findById(id);
		if(sinhvien.isPresent()) {
			return sinhvien.get();
		}else {
			return null;
		}
	}


	@Override
	public void DeleteSinhvienById(long id) {
		Optional<Sinhvien> sinhvien = sinhvienrepository.findById(id);
		if(sinhvien.isPresent()) {
			sinhvienrepository.deleteById(id);
		}else {
			System.out.println("Khong the xoa");
		}
	}
	

}
