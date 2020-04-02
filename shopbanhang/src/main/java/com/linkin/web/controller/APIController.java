package com.linkin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.linkin.model.ConGaDTO;
import com.linkin.service.ConGaService;

@RestController
public class APIController {

	@Autowired
	private ConGaService conGaService;

	@GetMapping(value = "/list/conga", produces = { "application/json" })
	public List<ConGaDTO> searchConGaAPI(@RequestParam(value = "keyword", required = false) String keyword) {
		keyword = keyword == null ? "" : keyword;
		// mac dinh 10 ban ghi 1 trang
		List<ConGaDTO> list = conGaService.search(keyword);
		return list;
	}

//	@PostMapping(value = "/add/conga", produces = { "application/json" })
//	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, value = "add/conga", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public void addConGaPostAPI(@RequestBody ConGaDTO conGaDTO) {
		conGaService.add(conGaDTO);
	}// tắt đi k cho nó chạy nữa cai nao tat, port 8080 nó đang bị dùng r k debug đc dung cai cai do do may

}
