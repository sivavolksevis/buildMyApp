package com.volksevis.b2bapp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommunicationUtility implements ICommunicationUtility {

	private static final Logger logger = LoggerFactory.getLogger(CommunicationUtility.class);

	@Override
	public boolean sendTextMessage(String message, String phoneNumber) {
		logger.info("In sendTextMessage to single mobile  -  Method Started in " + this.getClass());
		try {
			configureHTTPURLConnection();
			StringBuilder result = new StringBuilder();
			String smsThirdPartyURL = "https://sms.movesms.co.ke/api/compose?";
			String encodedMessage = URLEncoder.encode(message, "UTF-8");
			String urlParameters = "username=volksevis&api_key=EuSO7gLoPtAG339kQTVosJg417zspPo6rDmspSacXUMKQ9A5r7&sender=SMARTLINK&to="
					+ phoneNumber + "&message=" + encodedMessage + "&msgtype=5&dlr=0";
			URL urlObject = new URL(smsThirdPartyURL + urlParameters);
			HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			disconnect(connection);
			logger.info("In sendTextMessage to single mobile  -  Method ended in " + this.getClass());
			if (connection.getResponseMessage().equals("OK")) {
				return true;
			} else {
				logger.warn(connection.getResponseMessage());
				return false;
			}
		} catch (Exception exception) {
			logger.error("Exception occured while sending SMS " + exception.getMessage());
			return false;
		}
	}

	private void configureHTTPURLConnection() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");

		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		};
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

	private void disconnect(HttpURLConnection connection) {
		connection.disconnect();
	}

}
