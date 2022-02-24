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

import com.example.demo.model.Lophoc;
import com.example.demo.service.LophocService;

@RestController
@RequestMapping("/api/lophoc")
public class LophocController {
	private LophocService lophocservice;

	public LophocController(LophocService lophocservice) {
		super();
		this.lophocservice = lophocservice;
	}
	
	@PostMapping
	public ResponseEntity<Lophoc> saveLophoc(@RequestBody Lophoc lophoc){
		return new ResponseEntity<Lophoc>(lophocservice.saveLophoc(lophoc), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Lophoc> getAllLophoc(){
		return lophocservice.getAllLophoc();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteLophocById(@PathVariable("id") long Lophocid){
		lophocservice.DeleteLophocById(Lophocid);
		return new ResponseEntity<String>("Xoa thanh cong! ", HttpStatus.NO_CONTENT);
	}
	@GetMapping("{id}")
	public ResponseEntity<Lophoc> getLopHocById(@PathVariable("id") long lophocid){
		return new ResponseEntity<Lophoc>(lophocservice.GetLophocById(lophocid), HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Lophoc> updateLopHocById(@PathVariable("id") long lophocid, @RequestBody Lophoc lophoc){
		return new ResponseEntity<Lophoc>(lophocservice.updateLophoc(lophoc,lophocid), HttpStatus.OK);
	}
}
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

import com.example.demo.model.Lophoc;
import com.example.demo.service.LophocService;

@RestController
@RequestMapping("/api/lophoc")
public class LophocController {
	private LophocService lophocservice;

	public LophocController(LophocService lophocservice) {
		super();
		this.lophocservice = lophocservice;
	}
	
	@PostMapping
	public ResponseEntity<Lophoc> saveLophoc(@RequestBody Lophoc lophoc){
		return new ResponseEntity<Lophoc>(lophocservice.saveLophoc(lophoc), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Lophoc> getAllLophoc(){
		return lophocservice.getAllLophoc();
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteLophocById(@PathVariable("id") long Lophocid){
		lophocservice.DeleteLophocById(Lophocid);
		return new ResponseEntity<String>("Xoa thanh cong! ", HttpStatus.NO_CONTENT);
	}
	@GetMapping("{id}")
	public ResponseEntity<Lophoc> getLopHocById(@PathVariable("id") long lophocid){
		return new ResponseEntity<Lophoc>(lophocservice.GetLophocById(lophocid), HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Lophoc> updateLopHocById(@PathVariable("id") long lophocid, @RequestBody Lophoc lophoc){
		return new ResponseEntity<Lophoc>(lophocservice.updateLophoc(lophoc,lophocid), HttpStatus.OK);
	}
}
