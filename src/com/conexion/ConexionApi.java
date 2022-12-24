package com.conexion;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Scanner;
import org.json.JSONObject;

public class ConexionApi {

	public enum ConvertCoin {
		USD, EUR, COP, BTC, ARS, MXN, CLP, PEN, CRC, BRL, DOP, SVC, BOB
	}

	public static Double convertConexion(String from, String to, Double amount) {

		try {
			URL url = new URL(
					"https://api.getgeoapi.com/v2/currency/convert?api_key=02d64c36ab1702f7c2a39d8001dea0017409f3ae&from="
							+ from + "&to=" + to + "&amount=" + amount + "&format=json");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("Ocurrio un error " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}

				scanner.close();
				// System.out.print(informationString);
				JSONObject jsonObject = new JSONObject(informationString.toString());

				double exchangeRate = jsonObject.getJSONObject("rates").getJSONObject(to).getDouble("rate");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;

	}

	public static void main(String[] args) {

		try {
			URL url = new URL(
					"https://api.getgeoapi.com/v2/currency/convert?api_key=02d64c36ab1702f7c2a39d8001dea0017409f3ae&from="
							+ "USD" + "&to=" + "ARS" + "&amount=" + "200" + "&format=json");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("Ocurrio un error " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}

				scanner.close();
				// System.out.print(informationString);
				JSONObject jsonObject = new JSONObject(informationString.toString());

				System.out.println(jsonObject.getJSONObject("rates").getJSONObject("ARS").getDouble("rate"));

			}

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
