package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundExeption;
import com.example.demo.model.LopHoc;
import com.example.demo.repository.LopHocRepository;
import com.example.demo.service.LopHocService;

@Service
public class LopHocServiceImpl implements LopHocService {
	
	@Autowired
	private LopHocRepository lophocrepository;
	
	@Override
	public LopHoc saveLopHoc(LopHoc lophoc) {
		return lophocrepository.save(lophoc);
	}


	@Override
	public LopHoc updateLopHoc(LopHoc Class, long id) {
		LopHoc exitingClass = lophocrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Class", "Id", id));
		exitingClass.setName(Class.getName());
		lophocrepository.save(exitingClass);
		return exitingClass;
	}

	@Override
	public void deleteLopHocById(long id) {
		lophocrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Class","Id", id));
		lophocrepository.deleteById(id);
	}

	@Override
	public List<LopHoc> findAllLopHoc() {
			return lophocrepository.findAll();
	}



	@Override
	public LopHoc findLopHocById(long id) {
		return lophocrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Class","Id", id));
	}

}
