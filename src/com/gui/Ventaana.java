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
import java.text.DecimalFormat;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class Ventaana extends JFrame {

	private JPanel contentPane;
	private JTextField importeField;
	private JTextField resultadoField;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Ventaana() {
		setForeground(new Color(255, 153, 102));
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventaana.class.getResource("/com/images/Coin.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel bg = new JPanel();
		bg.setBackground(new Color(255, 153, 51));
		bg.setBorder(null);
		bg.setBounds(0, 0, 816, 436);
		contentPane.add(bg);
		bg.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		panel.setBounds(253, 48, 310, 329);
		bg.add(panel);
		panel.setLayout(null);

		JButton convertirButton = new JButton("Convertir");
		convertirButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		convertirButton.setBounds(82, 224, 146, 42);
		panel.add(convertirButton);
		convertirButton.setBackground(new Color(255, 153, 102));
		convertirButton.setForeground(new Color(255, 255, 255));
		convertirButton.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel importeLabel = new JLabel("Importe:");
		importeLabel.setForeground(new Color(255, 255, 255));
		importeLabel.setBounds(0, 61, 70, 28);
		panel.add(importeLabel);
		importeLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		importeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		importeField = new JTextField();
		importeField.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		importeField.setForeground(new Color(255, 255, 255));
		importeField.setBackground(new Color(255, 153, 0));
		importeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9') {
					e.consume();
				}
			}
		});
		importeField.setFont(new Font("Roboto", Font.BOLD, 15));
		importeField.setBounds(69, 61, 172, 28);
		panel.add(importeField);
		importeField.setColumns(10);

		JComboBox convertirDeBox = new JComboBox();
		convertirDeBox.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		convertirDeBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		convertirDeBox.setForeground(new Color(255, 255, 255));
		convertirDeBox.setModel(new DefaultComboBoxModel(new String[] { "Elija la moneda a convertir",
				ConvertCoin.ARS.toString(), ConvertCoin.USD.toString(), ConvertCoin.EUR.toString(),
				ConvertCoin.CLP.toString(), ConvertCoin.SVC.toString(), ConvertCoin.MXN.toString() }));
		convertirDeBox.setBounds(50, 100, 209, 22);
		panel.add(convertirDeBox);
		convertirDeBox.setBackground(new Color(255, 153, 0));
		convertirDeBox.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirDeBox.setToolTipText("");

		JComboBox convertirABox = new JComboBox();
		convertirABox.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		convertirABox.setForeground(new Color(255, 255, 255));
		convertirABox.setModel(new DefaultComboBoxModel(new String[] {"Elija la moneda a convertir", "ARS", "USD", "EUR", "CLP", "SVC", "MXN"}));
		convertirABox.setBounds(50, 152, 209, 22);
		panel.add(convertirABox);
		convertirABox.setBackground(new Color(255, 153, 0));
		convertirABox.setToolTipText("");
		convertirABox.setFont(new Font("Roboto", Font.PLAIN, 15));

		JLabel convertirDeLabel = new JLabel("De:");
		convertirDeLabel.setForeground(new Color(255, 255, 255));
		convertirDeLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirDeLabel.setBounds(19, 101, 29, 21);
		panel.add(convertirDeLabel);

		JLabel convertirALabel = new JLabel("A:");
		convertirALabel.setForeground(new Color(255, 255, 255));
		convertirALabel.setBackground(new Color(255, 255, 255));
		convertirALabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirALabel.setBounds(24, 152, 24, 22);
		panel.add(convertirALabel);

		resultadoField = new JTextField();
		resultadoField.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		resultadoField.setForeground(new Color(255, 255, 255));
		resultadoField.setBackground(new Color(255, 153, 51));
		resultadoField.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoField.setEditable(false);
		resultadoField.setFont(new Font("Roboto", Font.BOLD, 15));
		resultadoField.setColumns(10);
		resultadoField.setBounds(15, 185, 279, 28);
		panel.add(resultadoField);

		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
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
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setBounds(110, 277, 89, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ventaana.class.getResource("/com/images/Coin.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 90, 237, 244);
		bg.add(lblNewLabel);

		JLabel tittleLabel = new JLabel("Conversor De Divisas");
		tittleLabel.setBounds(275, 11, 265, 33);
		bg.add(tittleLabel);
		tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLabel.setBackground(new Color(0, 0, 0));
		tittleLabel.setForeground(new Color(255, 255, 255));
		tittleLabel.setFont(new Font("Roboto", Font.BOLD, 28));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ventaana.class.getResource("/com/images/Coin.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(569, 90, 237, 244);
		bg.add(lblNewLabel_1);

		convertirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = importeField.getText();
				//double amount = Double.parseDouble(importeField.getText());
				String from = (String) convertirDeBox.getSelectedItem();
				String to = (String) convertirABox.getSelectedItem();
				if (convertirDeBox.getSelectedIndex() == 0 || convertirABox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(panel, "Por favor selecione una moneda");
				}

				if (importeField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Por favor ingrese un importe");
				}
				try {
					
					URL url = new URL(
							"https://api.getgeoapi.com/v2/currency/convert?api_key=02d64c36ab1702f7c2a39d8001dea0017409f3ae&from="+ from + "&to=" + to + "&amount=" + amount + "&format=json");

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
					double resultado = Double.parseDouble(amount)*exchangeRate;
					DecimalFormat formato = new DecimalFormat("0.00");
					resultadoField.setText("La conversion de " + from + " a " + to + " es " + formato.format(resultado));
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
	}
}
