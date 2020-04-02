package com.linkin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkin.dao.ConGaDao;
import com.linkin.entity.ConGa;
import com.linkin.model.ConGaDTO;
import com.linkin.service.ConGaService;

@Transactional
@Service
public class ConGaServiceImpl implements ConGaService {
	@Autowired
	ConGaDao conGaDao;

	@Override
	public void add(ConGaDTO conGaDTO) {
		ConGa conGa = new ConGa();
		conGa.setId(conGaDTO.getId());
		conGa.setName(conGaDTO.getName());
		conGa.setAge(conGaDTO.getAge());
		conGaDao.add(conGa);
	}

	@Override
	public void update(ConGaDTO conGaDTO) {
		ConGa conGa = conGaDao.get(conGaDTO.getId());
		if (conGa != null) {
			conGa.setId(conGaDTO.getId());
			conGa.setName(conGaDTO.getName());
			conGa.setAge(conGaDTO.getAge());
			conGaDao.update(conGa);
		}

	}

	@Override
	public void delete(Long id) {
		ConGa conGa = conGaDao.get(id);
		if (conGa != null) {
			conGaDao.delete(conGa);
		}
	}

	@Override
	public ConGaDTO get(Long id) {
		ConGa conGa = conGaDao.get(id);
		ConGaDTO conGaDTO = new ConGaDTO();

		conGaDTO.setAge(conGa.getAge());
		conGaDTO.setId(conGa.getId());
		conGaDTO.setName(conGa.getName());

		return conGaDTO;
	}

	@Override
	public List<ConGaDTO> search(String name) {
		List<ConGa> list = conGaDao.search(name);
		List<ConGaDTO> listDTO = new ArrayList<ConGaDTO>();
		for (ConGa conGas : list) {
			ConGaDTO conGaDTO = new ConGaDTO();
			conGaDTO.setId(conGas.getId());
			conGaDTO.setName(conGas.getName());
			conGaDTO.setAge(conGas.getAge());
			listDTO.add(conGaDTO);
		}
		return listDTO;
	}

}
