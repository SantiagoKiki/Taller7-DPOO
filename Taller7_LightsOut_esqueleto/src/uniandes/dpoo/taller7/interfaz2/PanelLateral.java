package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelLateral extends JPanel {
    private JButton botonNuevo;
    private JButton botonReinicio;
    private JButton botonTOP10;
    private JButton botonCambiarJugador;
    
    public PanelLateral() {
        setLayout(new GridLayout(4, 1)); 
        botonNuevo = new JButton("Nuevo");
        botonReinicio = new JButton("Reiniciar");
        botonTOP10 = new JButton("TOP-10");
        botonCambiarJugador = new JButton("Cambiar Jugador");
        add(botonNuevo);
        add(botonReinicio);
        add(botonTOP10);
        add(botonCambiarJugador);
    }
}