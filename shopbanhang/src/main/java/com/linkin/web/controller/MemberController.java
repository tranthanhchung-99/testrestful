package com.linkin.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.linkin.model.BillDTO;
import com.linkin.model.BillProductDTO;
import com.linkin.model.CommentDTO;
import com.linkin.model.ReviewDTO;
import com.linkin.model.UserDTO;
import com.linkin.model.UserPrincipal;
import com.linkin.service.BillProductService;
import com.linkin.service.BillService;
import com.linkin.service.CommentService;
import com.linkin.service.EmailService;
//import com.linkin.service.EmailService;
import com.linkin.service.ProductService;
import com.linkin.service.ReviewService;
import com.linkin.service.SMSService;
import com.linkin.service.UserService;

@Controller
public class MemberController {

	@Autowired
	CommentService commentService;

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@Autowired
	BillProductService billProductService;

	@Autowired
	BillService billService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	SMSService smsService;

	@Autowired
	EmailService emailService;

	@PostMapping(value = "/member/comment")
	public String comment(HttpServletRequest request, @ModelAttribute CommentDTO commentDTO) {
		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = principal.getId();

		commentDTO.setUserId(userId);
		commentService.insert(commentDTO);
		return "redirect:/product?id=" + commentDTO.getProductId();
	}

	@PostMapping(value = "/member/review")
	public String review(HttpServletRequest request, @ModelAttribute ReviewDTO reviewDTO) {
		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = principal.getId();
		reviewDTO.setUserId(userId);
		reviewService.add(reviewDTO);
		return "redirect:/product?id=" + reviewDTO.getProductId();
	}

	@GetMapping(value = "/member/bill/add")
	public String addOrder(HttpSession session, @RequestParam(value = "page", required = false) Integer page,
			Model model) throws IOException {
		// lay member dang nhap hien tai
		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UserDTO user = new UserDTO();
		user.setId(principal.getId());

		// lay sp trong gio hang
		Object object = session.getAttribute("cart");

		if (object != null) {
			Map<String, BillProductDTO> map = (Map<String, BillProductDTO>) object;

			BillDTO bill = new BillDTO();
			bill.setUser(user);
			bill.setStatus("NEW");
			billService.insert(bill);

			long totalPrice = 0;
			for (Entry<String, BillProductDTO> entry : map.entrySet()) {
				BillProductDTO billProduct = entry.getValue();
				billProduct.setBill(bill);

				billProductService.insert(billProduct);

				totalPrice = totalPrice + (billProduct.getQuantity() * billProduct.getUnitPrice());

				/// discount
				page = page == null ? 1 : page;
				List<BillDTO> list = billService.searchByBuyerId(principal.getId(), 0, page * 10); // search trong bang
																									// bill

				// if (list.isEmpty() == true ) {// lan dau mua
				if (list.size() == 1) { // lan dau mua
					bill.setPriceTotal((totalPrice - (billProduct.getQuantity() * billProduct.getUnitPrice() * 5 / 100)));
					bill.setDiscountPercent(5);
					// bill.setStatus("OLD");
					// bill.setTotal(totalPrice);
					// model.addAttribute("a", totalPrice);
					System.out.println("khuyen mai 5% cho lan thanh toan dau tien cua ban!!!!" + bill.getPriceTotal());
					// chưa cho hiển thị dc giá lúc chưa giảm.
				} else {

					bill.setPriceTotal(totalPrice);
					bill.setDiscountPercent(0);
					bill.setStatus("OLD");
				}
				billService.update(bill);// udpate lai gia
			}
			// goi sms service
			// SMSDTO smsdto = new SMSDTO();
			// smsdto.setCustomerPhone(String.valueOf((principal.getPhone())));
			// smsdto.setContent("Bạn vừa thanh toán thành công đơn hàng trên hệ thống trung
			// tâm java!!!");

			// smsService.sendSMS(smsdto);

			String content = "";
			
			for (BillProductDTO i : map.values()) { 
				System.out.println("sản phẩm: " + i.getProduct().getName() + " Số tiền: " + i.getUnitPrice()*i.getQuantity());
				content += "Sản phẩm: " + i.getProduct().getName() + ", Số tiền: " + i.getUnitPrice()*i.getQuantity()
						+ " (đ); \n";
			}

			// gửi email sau khi thanh toán
			emailService.sendSimpleMessage(principal.getEmail(), "Hóa đơn thanh toán",
					"Bạn vừa thanh toán thành công đơn hàng trên hệ thống trung tâm java!!! \n" + content + "\n Tổng tiền: " + totalPrice + " (đ)");
			
			// xóa cart khi đã thanh toán
			session.removeAttribute("cart");

			return "redirect:/member/bills";
		}
		return "redirect:/products";
	}

	@GetMapping(value = "/member/bills")
	public String bills(HttpServletRequest request, @RequestParam(value = "keyword", required = false) Long keyword,
			@RequestParam(value = "page", required = false) Integer page) {
		UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		page = page == null ? 1 : page;
		keyword = principal.getId();
		List<BillDTO> listBill = billService.searchByBuyerId(keyword, 0, page * 10); // search trong bang bill
		request.setAttribute("bills", listBill);// danh sach bill cua 1 client
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		return "member/bills";
	}

	long billId;// lưu tạm thời giá trị id bill taitle

	@GetMapping(value = "/member/bill")
	public String billDetail(HttpServletRequest request, @RequestParam(name = "billId", required = true) Long billId,
			@RequestParam(value = "keyword", required = false) Long keyword,
			@RequestParam(value = "page", required = false) Integer page) {
		/*
		 * BillDTO billDTO = billService.get(billId); request.setAttribute("bill",
		 * billDTO);
		 */
		this.billId = billId;
		page = page == null ? 1 : page;
		keyword = billId;
		List<BillProductDTO> listBillProduct = billProductService.searchByBill(keyword, 0, page * 10);// danh sach san
																										// pham trong 1
		// bill
		request.setAttribute("billProducts", listBillProduct);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		return "member/bill";
	}

	// xóa item in list bill
	@GetMapping(value = "/member/delete/bills")
	public String deleteBillsProduct(@RequestParam(name = "billId", required = true) Long billId) {
		billService.delete(billId);
		return "redirect:/member/bills";
	}

	// xóa item in list bill detail
	@GetMapping(value = "/member/delete/bill")
	public String deleteBillProduct(@RequestParam(name = "billId", required = true) Long billId) {
		System.out.println(billId);
		System.out.println();
		billProductService.delete(billId);
		return "redirect:/member/bill?billId=" + this.billId;
	}
}
