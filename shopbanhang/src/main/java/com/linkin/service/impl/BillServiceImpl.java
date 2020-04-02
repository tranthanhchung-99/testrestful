package com.linkin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkin.dao.BillDao;
import com.linkin.entity.Bill;
import com.linkin.entity.User;
import com.linkin.model.BillDTO;
import com.linkin.model.UserDTO;
import com.linkin.service.BillService;
import com.linkin.utils.DateTimeUtils;

@Transactional
@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillDao billDao;

	@Override
	public void insert(BillDTO billDTO) {
		Bill bill = new Bill();
		bill.setBuyDate(new Date());
		bill.setBuyer(new User(billDTO.getUser().getId()));
		bill.setStatus(billDTO.getStatus());

		billDao.insert(bill);
		billDTO.setId(bill.getId());
	}

	@Override
	public void update(BillDTO billDTO) {
		Bill bill = billDao.get(billDTO.getId());
		if (bill != null) {
			bill.setPriceTotal(billDTO.getPriceTotal());
			bill.setDiscountPercent(billDTO.getDiscountPercent());
			bill.setStatus(billDTO.getStatus());

			billDao.update(bill);
		}

	}

	@Override
	public void delete(Long id) {
		Bill bill = billDao.get(id);
		if (bill != null) {
			billDao.delete(bill);
		}
	}

	@Override
	public BillDTO get(Long id) {
		Bill bill = billDao.get(id);
		return convertDTO(bill);
	}

	@Override
	public List<BillDTO> search(String findName, int start, int length) {
		List<Bill> bills = billDao.search(findName, start, length);
		List<BillDTO> billDTOs = new ArrayList<BillDTO>();
		for (Bill bill : bills) {
			billDTOs.add(convertDTO(bill));
		}
		return billDTOs;
	}

	@Override
	public List<BillDTO> searchByBuyerId(Long buyerId , int start, int length) {
		List<Bill> bills = billDao.searchByBuyerId(buyerId, start, length);
		List<BillDTO> billDTOs = new ArrayList<BillDTO>();
		if (bills.isEmpty()) {
			return null;
		} else {
			for (Bill bill : bills) {
				billDTOs.add(convertDTO(bill));
			}
			return billDTOs;
		}
		
	}

	private BillDTO convertDTO(Bill bill) {
		BillDTO billDTO = new BillDTO();
		billDTO.setId(bill.getId());
		billDTO.setBuyDate(DateTimeUtils.formatDate(bill.getBuyDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
		billDTO.setPriceTotal(bill.getPriceTotal());
		billDTO.setDiscountPercent(bill.getDiscountPercent());

		UserDTO userDTO = new UserDTO();
		userDTO.setId(bill.getBuyer().getId());
		userDTO.setAddress(bill.getBuyer().getAddress());
		userDTO.setName(bill.getBuyer().getName());
		billDTO.setUser(userDTO);

		return billDTO;
	}
}
