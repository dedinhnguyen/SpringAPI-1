package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundExeption;
import com.example.demo.model.Lophoc;
import com.example.demo.repository.LophocRepository;
import com.example.demo.service.LophocService;

@Service
public class LophocServiceImpl implements LophocService {
	
	@Autowired
	private LophocRepository lophocrepository;
	
	@Override
	public Lophoc saveLophoc(Lophoc lophoc) {
		// TODO Auto-generated method stub
		
		return lophocrepository.save(lophoc);
	}

	

	@Override
	public void DeleteLophocById(long id) {
		lophocrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc","Id", id));
		lophocrepository.deleteById(id);
	}
	@Override
	public Lophoc updateLophoc(Lophoc lophoc, long id) {
		Lophoc exitinglophoc = lophocrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc", "Id", id));
		exitinglophoc.setName(lophoc.getName());
		lophocrepository.save(exitinglophoc);
		return exitinglophoc;
	}

	@Override
	public List<Lophoc> getAllLophoc() {
		// TODO Auto-generated method stub
		return lophocrepository.findAll();
	}

	@Override
	public Lophoc GetLophocById(long id) {
		return lophocrepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Lophoc","Id", id));
	}
}
