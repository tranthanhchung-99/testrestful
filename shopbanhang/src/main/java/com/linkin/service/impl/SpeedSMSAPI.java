package com.linkin.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.linkin.model.SMSDTO;
import com.linkin.service.SMSService;

@Service
public class SpeedSMSAPI implements SMSService {

	@Override
	public void sendSMS(SMSDTO smsdto) {
		try {
			final String API_URL = "QHIxOwqRHJ7dDTo20NMIz7P_W0gGGXAM";
			String mAccessToken = "ZnVqaWFpcmV2bjpNNmI5UTl0Z212";

			String json2 = "{\"from\": \"SHOP\", \"to\": \"" + smsdto.getCustomerPhone() + "\", \"text\":\""
					+ smsdto.getContent() + "\"}";//content gửi id đơn hàng: b vừa thành công đơn hàng trên hệ thống trung tâm java
			URL url = new URL(API_URL + "/webapi/sendSMS");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			String basicAuth = "Basic " + mAccessToken;
			conn.setRequestProperty("Authorization", basicAuth);
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(json2);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine = "";
			StringBuffer buffer = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			System.out.println(buffer.toString());
		} catch (Exception ex) {
			System.err.println("SEND SMS error");
		}
	}
}
