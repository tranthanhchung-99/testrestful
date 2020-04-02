package com.linkin.service;

import java.util.List;

import com.linkin.model.ConGaDTO;

public interface ConGaService {
	void add(ConGaDTO conGaDTO);
	void update(ConGaDTO conGaDTO);
	void delete (Long id);
	ConGaDTO get (Long id);
	List<ConGaDTO> search(String name);
}
