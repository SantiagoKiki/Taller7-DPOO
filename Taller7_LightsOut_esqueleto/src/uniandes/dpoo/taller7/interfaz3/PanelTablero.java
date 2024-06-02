package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelTablero extends JPanel implements MouseListener {
	
	public int[][] cantidades;
	public boolean[][] tablero;
	public Inicio inicio;
	private int tamanio;
	public int widht;
	public int height;
	public int widthCasilla;
	public int heightCasilla;
	
	
	public PanelTablero(Inicio inicio, int tamanio, boolean[][]tablero) {
		this.inicio = inicio;
		this.tamanio = tamanio;
		this.tablero = tablero;
		this.cantidades = new int[tamanio][tamanio];
		addMouseListener(this);
		
		
	}

	@Override
	public void mousePressed(MouseEvent e){
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		cantidades[casilla[0]][casilla[1]]++;
		inicio.jugar(casilla[0], casilla[1]);
		repaint();
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y)
		{
		int ladoTablero = tablero.length;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / (ladoTablero+1);
		int anchoCasilla = anchoPanelTablero / ladoTablero;
		int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
			return new int[] { fila, columna };
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		widht = getWidth() - (10 * (tamanio + 1));
        height = getHeight() - (10 * (tamanio + 1));
        widthCasilla = widht / (tamanio+1);
        heightCasilla = height / (tamanio+1);	
        
        int posicionEjeX = 10;
        int posicionEjeY = 10;
        g2.setFont(new Font("Negrita", Font.PLAIN, 14));
        Image luz;
		try {
			int gap = 10;
			luz = ImageIO.read(new File("data/luz.png"));
	        for (int row = 0; row < tamanio; row++) {
	            for (int col = 0; col < tamanio; col++) {
	            	if(tablero[row][col]) {
	            		g2.setColor(new Color(255, 215, 3));
	            	} else {
	            		g2.setColor(new Color(101, 100, 91));
	            	}
	                g2.fillRoundRect(posicionEjeX, posicionEjeY, widthCasilla, heightCasilla, 20, 20);
	                g2.drawImage(luz, posicionEjeX, posicionEjeY, (int) (widthCasilla*0.8), (int) (heightCasilla*0.8), null);
            		g2.setColor(Color.BLACK);
	                g2.drawString(String.valueOf(cantidades[row][col]), posicionEjeX+widthCasilla-2*gap, posicionEjeY+heightCasilla-2*gap);
	                posicionEjeX += widthCasilla + gap;
	            }
	            posicionEjeY += heightCasilla + gap;
	            posicionEjeX = gap;
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void actualizar(boolean[][] tablero) {
		this.tablero = tablero;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}