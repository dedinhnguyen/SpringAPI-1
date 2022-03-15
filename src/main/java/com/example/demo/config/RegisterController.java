package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LopHocDTO;
import com.example.demo.dto.SinhVienDTO;
import com.example.demo.model.LopHoc;
import com.example.demo.model.SinhVien;
import com.example.demo.service.LopHocService;
import com.example.demo.service.SinhVienService;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LopHocService lophocService;
	
	@Autowired
	private SinhVienService sinhVienService;
	
	@PostMapping("{lophoc}")
	public ResponseEntity<LopHocDTO> registerLopHoc(@RequestBody LopHocDTO lophocDto) {

		LopHoc lophocRequest = modelMapper.map(lophocDto, LopHoc.class);

		LopHoc lophoc = lophocService.saveLopHoc(lophocRequest);

		LopHocDTO postResponse = modelMapper.map(lophoc, LopHocDTO.class);

		return new ResponseEntity<LopHocDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping("{sinhvien}")
	public ResponseEntity<SinhVienDTO> registerSinhVien(@RequestBody SinhVienDTO sinhvienDto) {
		
		// convert DTO to entity
		SinhVien sinhvienRequest = modelMapper.map(sinhvienDto, SinhVien.class);

		SinhVien sinhvien = sinhVienService.saveSinhVien(sinhvienRequest);

		// convert entity to DTO
		SinhVienDTO sinhVienResponse = modelMapper.map(sinhvien, SinhVienDTO.class);

		return new ResponseEntity<SinhVienDTO>(sinhVienResponse, HttpStatus.CREATED);
	}
}
