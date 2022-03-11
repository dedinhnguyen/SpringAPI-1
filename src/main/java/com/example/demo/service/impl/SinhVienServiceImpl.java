package com.example.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SinhVienDTO;
import com.example.demo.exception.ResourceNotFoundExeption;
import com.example.demo.model.SinhVien;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.service.SinhVienService;


@Service
public class SinhVienServiceImpl implements SinhVienService{
	
	@Autowired
	private ModelMapper modelMapper;
		
	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public SinhVien saveSinhVien(SinhVien sinhvien){
		return sinhVienRepository.save(sinhvien);
	}

	@Override
	public SinhVien updateSinhVien(SinhVien sinhvien,long id) {
		SinhVien exitingSinhvien = sinhVienRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("SinhVien", "Id", id));
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
		return sinhVienRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("SinhVien","Id", id));
	}

	@Override
	public void deleteSinhVienById(long id) {
		sinhVienRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("SinhVien","Id", id));
		sinhVienRepository.deleteById(id);
	}
	
	@Override
	public SinhVienDTO convertEntityToDTO(SinhVien sinhvien) {
		return modelMapper.map(sinhvien, SinhVienDTO.class);
		
	}
	
	@Override
	public SinhVien convertDTOToEntity(SinhVienDTO sinhviendto) {
		SinhVien sinhvien= new SinhVien();
		sinhvien = modelMapper.map(sinhviendto, SinhVien.class);
		return sinhVienRepository.save(sinhvien);
	}
}
