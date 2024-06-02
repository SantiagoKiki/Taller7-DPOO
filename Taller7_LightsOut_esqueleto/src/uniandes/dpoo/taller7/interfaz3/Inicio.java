package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class Inicio extends JFrame {
	
    public PanelSuperior panelSuperior;
    public PanelInferior panelInferior;
    public PanelLateral panelLateral;
    private File archivo;
	private Tablero tablero;
	public Top10 top10;
	public int tamanio = 5;
	public int dificultad = 5;
	public String jugador = "";
	public PanelTablero panelTablero;
	
    
    public Inicio() {
		this.archivo = new File("data/top10.csv");
		this.top10 = new Top10();
		top10.cargarRecords(archivo);
    	this.tablero = new Tablero(tamanio);
        this.panelSuperior = new PanelSuperior(this);
        this.panelInferior = new PanelInferior(2);
        this.panelLateral = new PanelLateral(this);   
        tablero.desordenar(dificultad);
        tablero.salvar_tablero();
        this.panelTablero = new PanelTablero(this, tamanio, tablero.darTablero());
        setLayout(new BorderLayout());
        add(this.panelSuperior, BorderLayout.NORTH);
        add(this.panelInferior, BorderLayout.SOUTH);
        add(this.panelLateral, BorderLayout.EAST);
        add(this.panelTablero, BorderLayout.CENTER);
        setTitle("Lights Out");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setSize(800, 700);
        
        addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				salvarTop10();
				Collection<RegistroTop10> registro = mostrarRegistrosTop10();
				
				new VentanaTop10(registro);
			}
    });
    }
    
	public void jugar(int i, int j) {
		tablero.jugar(i,  j);
		panelTablero.actualizar(tablero.darTablero());
		panelInferior.setJugadas(tablero.darJugadas());
		if(tablero.tableroIluminado()) {
			int puntaje = tablero.calcularPuntaje();
			String mensaje = "";
			if(top10.esTop10(puntaje)) {
				jugador = panelInferior.getJugador();
				top10.agregarRegistro(jugador, puntaje);
				mensaje = "\nEres parte del Top 10!";
			}
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¡Obtuviste " + puntaje + " puntos!" + mensaje + "\n¿Desea iniciar un nuevo juego?", "Fin del juego", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
			    nuevo();
			} else {
			    reiniciar();
			}
		}
	}
	public void reiniciar() {
		// TODO Auto-generated method stub 
		panelInferior.setJugadas(tablero.darJugadas());
		panelTablero.actualizar(tablero.darTablero());
		tablero.reiniciar();
	}

	public void nuevo() {
		this.dificultad = panelSuperior.getDificultad();
		this.tamanio = panelSuperior.retornarTamaño();
		this.tablero = new Tablero(tamanio);
		boolean[][] darTablero = tablero.darTablero();
		this.tablero.desordenar(dificultad);
		this.tablero.salvar_tablero();
		panelInferior.setJugadas(tablero.darJugadas());
		PanelTablero nuevoPanelTablero = new PanelTablero(this, tamanio, darTablero);
		add(nuevoPanelTablero, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void salvarTop10() {
		try {
			top10.agregarRegistro(jugador, dificultad);
			top10.salvarRecords(this.archivo);
		} catch (Exception e) {
			System.out.println("Ocurrió un error al salvar el Top 10");
			e.printStackTrace();
		}
	}
	public void cambiarJugador() {
		jugador = panelInferior.getJugador();
		if (jugador != "") {
		JOptionPane.showMessageDialog(this, "", "Cambiar jugador", JOptionPane.INFORMATION_MESSAGE);}
		else {
			JOptionPane.showMessageDialog(this, "", "Cambiar jugador", JOptionPane.INFORMATION_MESSAGE);
		}
	}
    
    
    public static void main(String[] args) {
        new Inicio();
        
    }
    
    public Collection<RegistroTop10> mostrarRegistrosTop10(){
    	
    	return top10.darRegistros();
    }
}


