package com.linkin.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.linkin.model.ConGaDTO;
import com.linkin.service.ConGaService;

@Controller
public class ConGaController {

	@Autowired
	private ConGaService conGaService;

	

	@GetMapping(value = "/conga/search")
	public String searchConGa(HttpServletRequest request,
			@RequestParam(value = "keyword", required = false) String keyword) {

		keyword = keyword == null ? "" : keyword;
		// mac dinh 10 ban ghi 1 trang
		List<ConGaDTO> list = conGaService.search(keyword);
		request.setAttribute("conGaList", list);

		request.setAttribute("keyword", keyword);

		return "client/conga/kich-thuoc-list";
	}

	@GetMapping(value = "/conga/add")
	public String addConGa() {
		return "client/conga/add-kich-thuoc";
	}

	@RequestMapping(value = "/conga/add", method = RequestMethod.POST)
	public String addConGaPost(@RequestParam String name, @RequestParam int age) {
		conGaService.add(new ConGaDTO(name, age));
		return "redirect:/conga/search"; 
	}

	@GetMapping(value = "/conga/update")
	public String updateConGaGet(Model model, @RequestParam(value = "id") Long id) {
		System.out.println("cahyxxxxxxxxxxxxxxxxx");
		ConGaDTO conga = conGaService.get(id);
		System.out.println("dddddddddđ");
		model.addAttribute("conga", conga);
		return "client/conga/update-kich-thuoc";
	}

	@PostMapping(value = "/conga/update")
	public String updateConGaPost(@ModelAttribute ConGaDTO conga) {
		conGaService.update(conga);
		return "redirect:/conga/search";
	}

	@GetMapping(value = "/conga/delete")
	public String deleteConGa(@RequestParam(value = "id") Long id) {
		conGaService.delete(id);
		return "redirect:/conga/search";
	}
}
