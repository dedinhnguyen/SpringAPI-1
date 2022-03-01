package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LopHoc;
import com.example.demo.service.LopHocService;

@RestController
@RequestMapping("/api/lophoc")
public class LopHocController {
	private LopHocService LopHocservice;

	public LopHocController(LopHocService LopHocservice) {
		super();
		this.LopHocservice = LopHocservice;
	}
	
	@PostMapping
	public ResponseEntity<LopHoc> saveLopHoc(@RequestBody LopHoc LopHoc){
		return new ResponseEntity<LopHoc>(LopHocservice.saveLopHoc(LopHoc), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<LopHoc> findAllLopHoc(){
		return LopHocservice.findAllLopHoc();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLopHocById(@PathVariable("id") long LopHocId){
		LopHocservice.deleteLopHocById(LopHocId);
		return new ResponseEntity<String>("Xoa thanh cong! ", HttpStatus.NO_CONTENT);
	}
	@GetMapping("{id}")
	public ResponseEntity<LopHoc> findLopHocById(@PathVariable("id") long LopHocId){
		return new ResponseEntity<LopHoc>(LopHocservice.findLopHocById(LopHocId), HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<LopHoc> updateLopHocById(@PathVariable("id") long LopHocId, @RequestBody LopHoc lophoc){
		return new ResponseEntity<LopHoc>(LopHocservice.updateLopHoc(lophoc,LopHocId), HttpStatus.OK);
	}
}
