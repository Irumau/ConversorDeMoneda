package com.conexion;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConexionApi {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://api.getgeoapi.com/v2/currency/convert?api_key=02d64c36ab1702f7c2a39d8001dea0017409f3ae");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			
			if(responseCode != 200) {
					throw new RuntimeException("Ocurrio un error" + responseCode);
			}else {
				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}
				scanner.close();
				
				System.out.println(informationString);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
