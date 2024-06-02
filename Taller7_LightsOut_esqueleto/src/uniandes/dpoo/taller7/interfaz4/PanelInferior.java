package uniandes.dpoo.taller7.interfaz4;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.util.Set;

import javax.swing.*;


public class PanelInferior extends JPanel{
	
	JLabel etiquetaJugadas;
	JTextField etiquetaJugador;
	JLabel etiquedaFijaJugador;
	String nombreJugador;
	
	public  PanelInferior(int movimientosJugados){
			JPanel panelPasar = new JPanel();
			JLabel etiquetaNumJugadas = new JLabel(String.valueOf(movimientosJugados));
			this.etiquetaJugador = new JTextField("");
			GridLayout configuracionInferior = new GridLayout(1,3);
			panelPasar.setLayout(configuracionInferior);
			this.etiquetaJugadas = new JLabel("");
			this.etiquedaFijaJugador = new JLabel("Jugador: ");
			JLabel nuevaEtiqueta = new JLabel("Jugadas: ");
			
			panelPasar.add(nuevaEtiqueta);
			panelPasar.add(etiquetaJugadas);
			panelPasar.add(etiquedaFijaJugador);
			panelPasar.add(etiquetaJugador);
			add(panelPasar);
	}

	public void setJugadas(int darJugadas) {
		// TODO Auto-generated method stub
		etiquetaJugadas.setText(String.valueOf(darJugadas));
		}

	public String getJugador() {
		// TODO Auto-generated method stub
		return etiquetaJugador.getText(); 
	}
	
	
}
