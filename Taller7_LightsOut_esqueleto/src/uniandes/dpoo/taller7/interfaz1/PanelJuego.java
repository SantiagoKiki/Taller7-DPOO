package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class PanelJuego extends JFrame {

    public PanelJuego() {
    	this.setTitle("Juego de LightsOut");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PanelJuego();
    }
}
