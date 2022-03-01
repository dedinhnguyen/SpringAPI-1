package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

//import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SinhVienDTO;
import com.example.demo.model.SinhVien;
import com.example.demo.service.SinhVienService;
//import com.example.demo.dto.SinhVienDTO;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController {
	
//	private ModelMapper modelMapper;
	private SinhVienService sinhvienservice;

	public SinhVienController(SinhVienService sinhvienservice) {
		super();
		this.sinhvienservice = sinhvienservice;
	}
	
	@PostMapping
	public ResponseEntity<SinhVien> saveSinhVien(@RequestBody SinhVien sinhvien){
		return new ResponseEntity<SinhVien>(sinhvienservice.saveSinhVien(sinhvien), HttpStatus.CREATED);
		
	}
	@GetMapping(value = "/list")
    public List<SinhVienDTO> getUserList(){
        List<SinhVien> sinhviens = sinhvienservice.findAllSinhVien();
        List<SinhVienDTO> dtoList = new ArrayList<>();
        for (SinhVien sinhvien : sinhviens){
            dtoList.add(new SinhVienDTO(sinhvien));
        }
        
        return dtoList;
    }
	
	@GetMapping
	public List<SinhVien> findAllSinhvien(){
		return sinhvienservice.findAllSinhVien();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SinhVien> findSinhvienById(@PathVariable("id") long SinhvienId){
		return new ResponseEntity<SinhVien>(sinhvienservice.findSinhVienById(SinhvienId), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSinhvienById(@PathVariable("id") long Sinhvienid){
		sinhvienservice.deleteSinhVienById(Sinhvienid);
		return new ResponseEntity<String>("Xoa thanh cong! ", HttpStatus.NO_CONTENT);
	}
	@PutMapping("{id}")
	public ResponseEntity<SinhVien> updateSinhVienById(@PathVariable("id") long sinhvienid, @RequestBody SinhVien sinhvien){
		return new ResponseEntity<SinhVien>(sinhvienservice.updateSinhVien(sinhvien,sinhvienid), HttpStatus.OK);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<SinhVien> updateSinhVien(@PathVariable("id") long sinhvienid, @RequestBody SinhVien sinhvien){
		return new ResponseEntity<SinhVien>(sinhvienservice.updateSinhVien(sinhvien,sinhvienid), HttpStatus.OK);
	}
}

