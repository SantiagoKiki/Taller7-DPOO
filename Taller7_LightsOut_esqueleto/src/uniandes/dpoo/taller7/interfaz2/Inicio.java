package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JFrame {
    public PanelSuperior panelSuperior;
    public PanelInferior panelInferior;
    public PanelLateral panelLateral;
    
    public Inicio() {
        this.panelSuperior = new PanelSuperior(this);
        this.panelInferior = new PanelInferior(2);
        this.panelLateral = new PanelLateral();   
        setLayout(new BorderLayout());
        add(this.panelSuperior, BorderLayout.NORTH);
        add(this.panelInferior, BorderLayout.SOUTH);
        add(this.panelLateral, BorderLayout.EAST);
        setTitle("Lights Out");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setSize(800, 700);
    }

    public static void main(String[] args) {
        new Inicio();
    }
}


