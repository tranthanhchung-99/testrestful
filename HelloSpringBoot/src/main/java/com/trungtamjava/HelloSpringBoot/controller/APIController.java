package com.trungtamjava.HelloSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trungtamjava.HelloSpringBoot.model.SinhVienDTO;
import com.trungtamjava.HelloSpringBoot.service.SinhVienService;


@Controller
@RestController
public class APIController {
	@Autowired
	private SinhVienService sinhVienService;

	@GetMapping(value = "/list-sinhvien", produces = { "application/json" })
	public List<SinhVienDTO> search() {
		List<SinhVienDTO> sinhVienDTOs = sinhVienService.search("");
		return sinhVienDTOs;
	}

	@PutMapping(value = "/update-sinhvien",produces = { "application/json" })
	public void update(@RequestBody SinhVienDTO sinhVienDTO) {
		sinhVienService.update(sinhVienDTO);
	}

	@PostMapping(value = "/add-sinhvien",produces = { "application/json" })
	@ResponseStatus(code=HttpStatus.CREATED)
	public SinhVienDTO addPost(@RequestBody SinhVienDTO sinhVienDTO) {
		sinhVienService.add(sinhVienDTO);
		return sinhVienDTO;
	}
	@DeleteMapping(value = "/sinhvien-delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		sinhVienService.delete(id);
	}
}
