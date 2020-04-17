package com.trungtamjava.HelloSpringBoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.HelloSpringBoot.model.SinhVienDTO;
import com.trungtamjava.HelloSpringBoot.service.SinhVienService;
@Controller
public class SinhVienController {
	@Autowired
	private SinhVienService userService;

	@GetMapping(value = "/sinhvien/search")
	public String searchUser(HttpServletRequest request) {
		
		List<SinhVienDTO> userList = userService.search("");
		request.setAttribute("userList", userList);
		System.out.println("tessssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		return "admin/user/users";
		
	}
	
	@GetMapping(value = "/sinhvien/add")
	public String AdminAddUserGet() {
		return "admin/user/add-user";
	}

	@PostMapping(value = "/sinhvien/add")
	public String AdminAddUserPost(@ModelAttribute(name = "adduser") SinhVienDTO user) {
		user.setEnabled(true);
		userService.add(user);
		return "redirect:/sinhvien/search";

	}

	@GetMapping(value = "/sinhvien/update")
	public String AdminUpdateUserGet(Model model, @RequestParam(name = "id") Long id) {
		SinhVienDTO user = userService.get(id);
		model.addAttribute("user", user);
		return "admin/user/update-user";
	}

	@PostMapping(value = "/sinhvien/update")
	public String changePassword(@ModelAttribute(name = "user") SinhVienDTO user) {
		userService.update(user);
		return "redirect:/sinhvien/search";
	}

	@GetMapping(value = "/admin/user/change-password")
	public String changePassword(Model model, @RequestParam(name = "id") Long id) {
		SinhVienDTO user = userService.get(id);
		model.addAttribute("user", user);
		return "admin/user/change-password";
	}

	@GetMapping(value = "/sinhvien/delete")
	public String deleteUser(Long id) {
		userService.delete(id);
		return "redirect:/sinhvien/search";
	}

}
