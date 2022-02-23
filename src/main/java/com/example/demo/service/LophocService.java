package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Lophoc;
public interface LophocService {
	Lophoc saveLophoc(Lophoc lophoc);
	void DeleteLophocById(long id);
	Lophoc updateLophoc(Lophoc lophoc,long id);
	List<Lophoc> getAllLophoc();
	Lophoc GetLophocById(long id);

}
