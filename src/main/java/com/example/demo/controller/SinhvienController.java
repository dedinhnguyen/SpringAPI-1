package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sinhvien;
import com.example.demo.service.SinhvienService;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhvienController {
	private SinhvienService sinhvienservice;

	public SinhvienController(SinhvienService sinhvienservice) {
		super();
		this.sinhvienservice = sinhvienservice;
	}
	
	@PostMapping
	public ResponseEntity<Sinhvien> saveSinhvien(@RequestBody Sinhvien sinhvien){
		return new ResponseEntity<Sinhvien>(sinhvienservice.saveSinhvien(sinhvien), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Sinhvien> getAllSinhvien(){
		return sinhvienservice.getAllSinhvien();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Sinhvien> GetSinhvienById(@PathVariable("id") long Sinhvienid){
		return new ResponseEntity<Sinhvien>(sinhvienservice.GetSinhvienById(Sinhvienid), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteSinhvienById(@PathVariable("id") long Sinhvienid){
		sinhvienservice.DeleteSinhvienById(Sinhvienid);
		return new ResponseEntity<String>("Xoa thanh cong! ", HttpStatus.OK);
	}

}
