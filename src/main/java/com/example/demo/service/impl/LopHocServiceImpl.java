package com.example.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LopHocDTO;

import com.example.demo.exception.ResourceNotFoundExeption;
import com.example.demo.model.LopHoc;
import com.example.demo.repository.LopHocRepository;
import com.example.demo.service.LopHocService;

@Service
public class LopHocServiceImpl implements LopHocService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LopHocRepository lopHocRepository;
	
	@Override
	public LopHoc saveLopHoc(LopHoc lophoc) {
		return lopHocRepository.save(lophoc);
	}

	@Override
	public LopHoc updateLopHoc(LopHoc Class, long id) {
		LopHoc exitingClass = lopHocRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("LopHoc", "Id", id));
		exitingClass.setName(Class.getName());
		lopHocRepository.save(exitingClass);
		return exitingClass;
	}

	@Override
	public void deleteLopHocById(long id) {
		lopHocRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("LopHoc","Id", id));
		lopHocRepository.deleteById(id);
	}

	@Override
	public List<LopHoc> findAllLopHoc() {
			return lopHocRepository.findAll();
	}

	@Override
	public LopHoc findLopHocById(long id) {
		return lopHocRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("LopHoc","Id", id));
	}
	@Override
	public LopHoc convertDTOToEntity(LopHocDTO lophocdto) {
		LopHoc lophoc= new LopHoc();
		lophoc = modelMapper.map(lophocdto, LopHoc.class);
		return lophoc;
		
	}

}
