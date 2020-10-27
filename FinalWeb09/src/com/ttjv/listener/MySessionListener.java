package com.ttjv.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	private static int soNguoiOnline;

	public static int getSoNguoiOnline() {
		return soNguoiOnline;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		soNguoiOnline++;
		System.out.println("vua tao session, them 1 nguoi online ");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		soNguoiOnline--;
		System.out.println("vua xoa session, xoa 1 nguoi online");

	}

}
