package com.gui;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;
import com.conexion.ConexionApi.ConvertCoin;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Ventaana extends JFrame {

	private JPanel contentPane;
	private JTextField importeField;
	private JTextField resultadoField;

	/**
	 * Create the frame.
	 */
	public Ventaana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventaana.class.getResource("/com/images/ImagenMoneda.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel bg = new JPanel();
		bg.setBorder(null);
		bg.setBounds(0, 0, 754, 412);
		contentPane.add(bg);
		bg.setLayout(null);

		JPanel bgl_1 = new JPanel();
		bgl_1.setBackground(new Color(0, 153, 255));
		bgl_1.setBounds(10, 11, 152, 390);
		bg.add(bgl_1);

		JPanel bg_2 = new JPanel();
		bg_2.setBackground(new Color(0, 153, 204));
		bg_2.setBounds(161, 11, 583, 87);
		bg.add(bg_2);

		JLabel tittleLabel = new JLabel("Conversor De Divisas");
		bg_2.add(tittleLabel);
		tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLabel.setBackground(new Color(0, 0, 0));
		tittleLabel.setForeground(new Color(255, 255, 255));
		tittleLabel.setFont(new Font("Roboto", Font.BOLD, 28));

		JPanel panel = new JPanel();
		panel.setBounds(161, 96, 583, 305);
		bg.add(panel);
		panel.setLayout(null);

		JButton convertirButton = new JButton("Convertir");
		convertirButton.setBounds(218, 178, 146, 42);
		panel.add(convertirButton);
		convertirButton.setBackground(new Color(0, 153, 255));
		convertirButton.setForeground(new Color(255, 255, 255));
		convertirButton.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel importeLabel = new JLabel("Importe:");
		importeLabel.setBounds(101, 33, 70, 28);
		panel.add(importeLabel);
		importeLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		importeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		importeField = new JTextField();
		importeField.setFont(new Font("Roboto", Font.BOLD, 15));
		importeField.setBounds(181, 34, 221, 28);
		panel.add(importeField);
		importeField.setColumns(10);


		JComboBox convertirDeBox = new JComboBox();
		convertirDeBox.setModel(new DefaultComboBoxModel(new String[] { "Elija la moneda a convertir",
				ConvertCoin.ARS.toString(), ConvertCoin.USD.toString(), ConvertCoin.EUR.toString(),
				ConvertCoin.CLP.toString(), ConvertCoin.SVC.toString(), ConvertCoin.MXN.toString() }));
		convertirDeBox.setBounds(181, 73, 221, 22);
		panel.add(convertirDeBox);
		convertirDeBox.setBackground(new Color(255, 255, 255));
		convertirDeBox.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirDeBox.setToolTipText("");

		JComboBox convertirABox = new JComboBox();
		convertirABox.setModel(new DefaultComboBoxModel(new String[] { "Elija la moneda a convertir",
				ConvertCoin.ARS.toString(), ConvertCoin.USD.toString(), ConvertCoin.EUR.toString(),
				ConvertCoin.CLP.toString(), ConvertCoin.SVC.toString(), ConvertCoin.MXN.toString() }));
		convertirABox.setBounds(181, 106, 221, 22);
		panel.add(convertirABox);
		convertirABox.setBackground(new Color(255, 255, 255));
		convertirABox.setToolTipText("");
		convertirABox.setFont(new Font("Roboto", Font.PLAIN, 15));

		JLabel convertirDeLabel = new JLabel("De:");
		convertirDeLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirDeLabel.setBounds(142, 74, 29, 21);
		panel.add(convertirDeLabel);

		JLabel convertirALabel = new JLabel("A:");
		convertirALabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirALabel.setBounds(147, 107, 24, 22);
		panel.add(convertirALabel);

		resultadoField = new JTextField();
		resultadoField.setForeground(new Color(255, 255, 255));
		resultadoField.setBackground(new Color(0, 153, 255));
		resultadoField.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoField.setEditable(false);
		resultadoField.setFont(new Font("Roboto", Font.BOLD, 15));
		resultadoField.setColumns(10);
		resultadoField.setBounds(142, 139, 299, 28);
		panel.add(resultadoField);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importeField.setText("");
				resultadoField.setText("");
				convertirDeBox.setSelectedIndex(0);
				convertirABox.setSelectedIndex(0);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(247, 231, 89, 23);
		panel.add(btnNewButton);

		convertirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = Double.parseDouble(importeField.getText());
				String from = (String) convertirDeBox.getSelectedItem();
				String to = (String) convertirABox.getSelectedItem();				
				
				if(convertirDeBox.getSelectedIndex() == 0 || convertirABox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(panel, "Por favor selecione una moneda");
				}				
				try {
					URL url = new URL(
							"https://api.getgeoapi.com/v2/currency/convert?api_key=02d64c36ab1702f7c2a39d8001dea0017409f3ae&from="
									+ from + "&to=" + to + "&amount=" + amount + "&format=json");

					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					conn.setRequestMethod("GET");
					conn.connect();
					int responseCode = conn.getResponseCode();


						StringBuilder informationString = new StringBuilder();
						Scanner scanner = new Scanner(url.openStream());

						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}

						scanner.close();
						JSONObject jsonObject = new JSONObject(informationString.toString());
						
						double exchangeRate = jsonObject.getJSONObject("rates").getJSONObject(to).getDouble("rate");
						double resultado = amount * exchangeRate;
						resultadoField.setText("La conversion de " + from + " a " + to + " es "+ Math.floor(resultado));
						
				} catch (Exception ex) {
					
				}

			}
		});
	}
}
