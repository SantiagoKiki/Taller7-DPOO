package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class PanelSuperior extends JPanel{
	public  int facil1 = 5;
	public  int medio1 = 7;
	public  int dificil1 = 10;
	public JComboBox compoTamanio;
	public Inicio inicio;
	public int tamanio;
	public int dificultad;
	
	public  PanelSuperior(Inicio inicio){
		this.inicio = inicio;
		JPanel panelSuperior = new JPanel();
		JPanel panelDificultades = new JPanel();
		GridLayout gridLayout = new GridLayout(1, 4);
		Color color = new Color(0x00, 0xc5, 0xe4);
		panelDificultades.setBackground(color);
		panelSuperior.setBackground(color);
	    panelSuperior.setLayout(gridLayout);
	    
	    JLabel etiquetaTamaño = new JLabel("Tamaño: ");
	    String[] arregloTamaño = { "5x5", "4x4", "3x3"};
	    JComboBox<String> compoTamanio = new JComboBox<>(arregloTamaño);
	    this.compoTamanio = compoTamanio;
	    JLabel etiquetaDificultad = new JLabel("Dificultad: ");
	    JRadioButton botonFacil = new JRadioButton();
	    JLabel facil = new JLabel("Fácil");
	    botonFacil.setBackground(color);	    
	    JRadioButton botonMedio = new JRadioButton(); 
	    botonMedio.setBackground(color);
	    JLabel medio = new JLabel("Medio");
	    JRadioButton botonDificil = new JRadioButton();
	    botonDificil.setBackground(color);
	    JLabel dificil = new JLabel("Difícil");
	   
	    
	    botonFacil.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (botonFacil.isSelected()) {
					dificultad = facil1;
				}
				else if (botonMedio.isSelected()) {
					dificultad = medio1;
				}
				else if (botonDificil.isSelected()) {
					dificultad = dificil1;	
				}
				
			}
	    	
	    });
	    compoTamanio.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = (String) compoTamanio.getSelectedItem();
				switch(s){ 
				case "3x3":
					tamanio = 3;
				case "4x4":
					tamanio = 4;
				case "5x5":
					tamanio = 5;
				case "6x6":
					tamanio = 6;
				
				}
			}
	    	
	    });

	    panelSuperior.add(etiquetaTamaño);
	    panelSuperior.add(compoTamanio);
	    panelSuperior.add(etiquetaDificultad);
	    panelDificultades.add(facil);
	    panelDificultades.add(botonFacil);
	    panelDificultades.add(medio);
	    panelDificultades.add(botonMedio);
	    panelDificultades.add(dificil);
	    panelDificultades.add(botonDificil);
	    panelSuperior.add(panelDificultades);
	    add(panelSuperior);
	    
	   
	    
	}
	public int retornarTamaño() {
		return tamanio;
		
	}
	public int getDificultad() {
		// TODO Auto-generated method stub
		return dificultad;
	}
	
	
		
	}


