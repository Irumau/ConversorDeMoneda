package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ventaana extends JFrame {

	private JPanel contentPane;
	private JTextField importeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventaana frame = new Ventaana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventaana() {
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
		
		JLabel tittleLabel = new JLabel("Conversor De Moneda");
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
		importeField.setBounds(181, 34, 221, 28);
		panel.add(importeField);
		importeField.setColumns(10);
		
		JComboBox convertirDeBox = new JComboBox();
		convertirDeBox.setModel(new DefaultComboBoxModel(new String[] {"Elija la moneda a convertir"}));
		convertirDeBox.setBounds(181, 73, 221, 22);
		panel.add(convertirDeBox);
		convertirDeBox.setBackground(new Color(255, 255, 255));
		convertirDeBox.setFont(new Font("Roboto", Font.PLAIN, 15));
		convertirDeBox.setToolTipText("");
		
		JComboBox convertirABox = new JComboBox();
		convertirABox.setModel(new DefaultComboBoxModel(new String[] {"Elija la moneda a convertir"}));
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
		convertirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
