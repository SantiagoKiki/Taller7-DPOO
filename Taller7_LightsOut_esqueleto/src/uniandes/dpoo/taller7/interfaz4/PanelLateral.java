package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelLateral extends JPanel {
	public Inicio inicio;
	public VentanaTop10 dialog;
    public JButton botonNuevo;
    public JButton botonReinicio;
    public JButton botonTOP10;
    public JButton botonCambiarJugador;
    
    public PanelLateral(Inicio inicio) {
    	
        setLayout(new GridLayout(4, 1)); 
        botonNuevo = new JButton("Nuevo");
        botonReinicio = new JButton("Reiniciar");
        botonTOP10 = new JButton("TOP-10");
        botonCambiarJugador = new JButton("Cambiar Jugador");
        
        botonNuevo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inicio.nuevo();
				
				}
			});
        botonReinicio.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inicio.reiniciar();
				
				}
			});
        
        botonTOP10.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog = new VentanaTop10(inicio.mostrarRegistrosTop10());
				
				}
			});
        
        
        
        
        
        
        
        add(botonNuevo);
        add(botonReinicio);
        add(botonTOP10);
        add(botonCambiarJugador);
        
        
        
        
    }
}