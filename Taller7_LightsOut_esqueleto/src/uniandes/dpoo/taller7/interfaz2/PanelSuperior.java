package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class PanelSuperior extends JPanel{
	public static int facil = 5;
	public static int medio = 7;
	public static int dificil = 10;
	public JComboBox compoTamaño;
	public Inicio inicio;
	
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
	    String[] arregloTamaño = { "3x3", "4x4", "5x5", "6x6"};
	    JComboBox<String> compoTamaño = new JComboBox<>(arregloTamaño);
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
	   
	    
	    panelSuperior.add(etiquetaTamaño);
	    panelSuperior.add(compoTamaño);
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
}
