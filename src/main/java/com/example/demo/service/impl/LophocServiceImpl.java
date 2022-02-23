package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Lophoc;
import com.example.demo.repository.LophocRepository;
import com.example.demo.service.LophocService;

@Service
public class LophocServiceImpl implements LophocService {
	
	private LophocRepository lophocrepository;
	
	public LophocServiceImpl(LophocRepository lophocrepository) {
		super();
		this.lophocrepository = lophocrepository;
	}
	
	@Override
	public Lophoc saveLophoc(Lophoc lophoc) {
		// TODO Auto-generated method stub
		
		return lophocrepository.save(lophoc);
	}

	

	@Override
	public void DeleteLophocById(long id) {
		// TODO Auto-generated method stub
		Optional<Lophoc> lophoc = lophocrepository.findById(id);
		if(lophoc.isPresent()) {
			lophocrepository.deleteById(id);
		}else {
			System.out.println("Khong the xoa lop hoc nay");
		}
	}

	@Override
	public Lophoc updateLophoc(Lophoc lophoc, long id) {
//		Optional<Lophoc> lophoc1= lophocrepository.findById(id);
//		if(lophoc1.isPresent()) {
//			lophoc1.setName(lophoc.getName());
//			Lophoc updatelophoc= lophocrepository.save(lophoc1);
//			return updatelophoc;
//		}else {
//			return null;
//		}
		return null;
	}

	@Override
	public List<Lophoc> getAllLophoc() {
		// TODO Auto-generated method stub
		return lophocrepository.findAll();
	}

	@Override
	public Lophoc GetLophocById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
