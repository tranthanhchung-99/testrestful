//package com.linkin.web.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.linkin.model.BillDTO;
//import com.linkin.model.BillProductDTO;
//import com.linkin.model.UserDTO;
//import com.linkin.model.UserPrincipal;
//import com.linkin.service.BillProductService;
//import com.linkin.service.BillService;
//
//@Controller
//public class AdminBillController {// mấy cái này vào k chir viet 2 ham de test thoi may cai khac van chay bt bang view 
//	@Autowired
//	BillService billService;
//	@Autowired
//	BillProductService billProductService;
//
//	@GetMapping(value = "/admin/bill/search")// cho ra tat ca cac bill trong database cua cac khach hang.
//	public String AdminBillSearch(HttpServletRequest request,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page) {
//		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		UserDTO user = new UserDTO();
//		user.setRole(principal.getRole());
//		if(user.getRole().equals("ROLE_ADMIN")) {
//			String admin= "ashgha";
//			request.setAttribute("admin", admin);
//		}else {
//			String admin= "";
//			request.setAttribute("admin", admin);
//		}
//		
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		List<BillDTO> listBill = billService.search(keyword, 0, page*10);
//		request.setAttribute("bills", listBill);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		return "admin/bill/bills";
//	}
//
//	@GetMapping(value = "/admin/billproduct/search")// chi tiet cac san pham da mua co trong 1 bill
//	public String AdminBillProductSearch(HttpServletRequest request, @RequestParam(name = "idBill") Long idBill,
//			@RequestParam(value = "keyword", required = false) Long keyword,
//			@RequestParam(value = "page", required = false) Integer page) {
//		page = page == null ? 1 : page;
//		keyword = idBill;
//		List<BillProductDTO> listBillProduct = billProductService.searchByBill(keyword, 0, page * 10);
//		request.setAttribute("billProducts", listBillProduct);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		return "admin/bill/bill";
//	}
//	@GetMapping(value = "/admin/delete/bills")
//	public String deleteBill(@RequestParam(name = "idBill", required = true) Long billId) {
//		billService.delete(billId);
//		return "redirect:/admin/bill/search";
//	}
//	//xóa item in list bill detail
//	@GetMapping(value = "/admin/delete/bill")
//	public String deleteBillProduct(@RequestParam(name = "idBill", required = true) Long billId) {
//		System.out.println(billId);
//		System.out.println();
//		billProductService.delete(billId);
//		return "redirect:/admin/billproduct/search?idBill="+billId;
//	}
//}
