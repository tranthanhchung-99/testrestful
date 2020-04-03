package com.trungtamjava.HelloSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.HelloSpringBoot.dao.SinhVienDao;
import com.trungtamjava.HelloSpringBoot.entity.SinhVien;
import com.trungtamjava.HelloSpringBoot.model.SinhVienDTO;

public interface SinhVienService {
	void add(SinhVienDTO sinhVien);
	void update(SinhVienDTO sinhVien);
	void delete(Long id);
	SinhVienDTO get (Long id);
	List<SinhVienDTO> search(String name);
}
@Transactional
@Service
class SinhVienServiceImpl implements SinhVienService{
	@Autowired SinhVienDao sinhVienDao;
	@Override
	public void add(SinhVienDTO sinhVien) {
		SinhVien sinhVien2= new SinhVien();
		sinhVien2.setId(sinhVien.getId());
		sinhVien2.setAddress(sinhVien.getAddress());
		sinhVien2.setAge(sinhVien.getAge());
		sinhVien2.setEmail(sinhVien.getEmail());
		sinhVien2.setEnabled(sinhVien.getEnabled());
		sinhVien2.setGender(sinhVien.getGender());
		sinhVien2.setName(sinhVien.getName());
		sinhVien2.setPassword(sinhVien.getPassword());
		sinhVien2.setPhone(sinhVien.getPhone());
		sinhVien2.setRole(sinhVien.getRole());
		sinhVien2.setUsername(sinhVien.getUsername());
		sinhVienDao.add(sinhVien2);
		
		
	}

	@Override
	public void update(SinhVienDTO sinhVien) {
		SinhVien sinhVien2=sinhVienDao.get(sinhVien.getId());
		if(sinhVien2!=null) {
			sinhVien2.setId(sinhVien.getId());
			sinhVien2.setAddress(sinhVien.getAddress());
			sinhVien2.setAge(sinhVien.getAge());
			sinhVien2.setEmail(sinhVien.getEmail());
			sinhVien2.setEnabled(sinhVien.getEnabled());
			sinhVien2.setGender(sinhVien.getGender());
			sinhVien2.setName(sinhVien.getName());
			sinhVien2.setPassword(sinhVien.getPassword());
			sinhVien2.setPhone(sinhVien.getPhone());
			sinhVien2.setRole(sinhVien.getRole());
			sinhVien2.setUsername(sinhVien.getUsername());
			sinhVienDao.update(sinhVien2);
		}
		
	}

	@Override
	public void delete(Long id) {
		SinhVien sinhVien2=sinhVienDao.get(id);
		if(sinhVien2!=null) {
			sinhVienDao.delete(sinhVien2);
		}
		
	}

	@Override
	public SinhVienDTO get(Long id) {
		SinhVien sinhVien=sinhVienDao.get(id);
		SinhVienDTO dto= new SinhVienDTO();
		dto.setId(sinhVien.getId());
		dto.setAddress(sinhVien.getAddress());
		dto.setAge(sinhVien.getAge());
		dto.setEmail(sinhVien.getEmail());
		dto.setEnabled(sinhVien.getEnabled());
		dto.setGender(sinhVien.getGender());
		dto.setName(sinhVien.getName());
		dto.setPassword(sinhVien.getPassword());
		dto.setPhone(sinhVien.getPhone());
		dto.setRole(sinhVien.getRole());
		dto.setUsername(sinhVien.getUsername());
		return dto;
	}

	@Override
	public List<SinhVienDTO> search(String name) {
		List<SinhVien> list = sinhVienDao.search(name);
		List<SinhVienDTO> listDTO= new ArrayList<SinhVienDTO>();
		for(SinhVien sinhVien:list) {
			SinhVienDTO dto= new SinhVienDTO();
			dto.setId(sinhVien.getId());
			dto.setAddress(sinhVien.getAddress());
			dto.setAge(sinhVien.getAge());
			dto.setEmail(sinhVien.getEmail());
			dto.setEnabled(sinhVien.getEnabled());
			dto.setGender(sinhVien.getGender());
			dto.setName(sinhVien.getName());
			dto.setPassword(sinhVien.getPassword());
			dto.setPhone(sinhVien.getPhone());
			dto.setRole(sinhVien.getRole());
			dto.setUsername(sinhVien.getUsername());
			listDTO.add(dto);
		}
		return listDTO;
	}
	
}