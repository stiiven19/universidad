package Interface;


import jaque4caballos.Caballo;
import jaque4caballos.Rey;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TableroGrafico extends JFrame{

	private JLabel [] 	letters;
	private JLabel[][]	numbers;
	private Color[]	colors;
        private  Rey     R; 
        private ArrayList<Caballo> Caballos;

	
	public TableroGrafico(ArrayList<Caballo> caballos,Rey R) {
		Caballos = caballos;
                this.R=R;
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("Ajedrez");
		setupWidgets();
        
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void setupWidgets() {
		
		letters = new JLabel[8];
		numbers = new JLabel[8][8];
		colors 	= new Color [8];
		addColors();
		setLayout(new GridLayout(9,8));
		
		Random number = new Random();
		/*//_____________________________________________________________________
                    for (int i = 0; i < 8; i++) {
			letters[i]=new JLabel();
			letters[i].setText("s");
			letters[i].setHorizontalAlignment(SwingConstants.CENTER);
			letters[i].setOpaque(true);
			//letters[i].setFont(new Font("Arial Black",1,40));
			letters[i].setBackground(colors[i]);
			add(letters[i]);
		}*/
		//--------------------------------------------------------------------------
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
                            numbers[i][j]=new JLabel();
                            numbers[i][j].setOpaque(true);
                            
                            if ((i + j) % 2 == 0) {
                                numbers[i][j].setBackground(Color.WHITE);
                            } else {
                                numbers[i][j].setBackground(Color.GRAY);
                            }
                            if (i == Caballos.get(0).getPosicionInicial_X()-1 && j == Caballos.get(0).getPosicionInicial_Y()-1) {
                                numbers[i][j].setText("C1");
                                numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                            }
                            if (i == Caballos.get(1).getPosicionInicial_X()-1 && j == Caballos.get(1).getPosicionInicial_Y()-1) {
                                numbers[i][j].setText("C2");
                                numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                            }
                            if (i == Caballos.get(2).getPosicionInicial_X()-1 && j == Caballos.get(2).getPosicionInicial_Y()-1) {
                                numbers[i][j].setText("C3");
                                numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                            }
                            if (i == Caballos.get(3).getPosicionInicial_X()-1 && j == Caballos.get(3).getPosicionInicial_Y()-1) {
                                numbers[i][j].setText("C4");
                                numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                            }
                            if (i == R.getPosicionInicial_X()-1 && j == R.getPosicionInicial_Y()-1) {
                                numbers[i][j].setText("R");
                                numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                            }
                            
                            add(numbers[i][j]);
                            /*numbers[i][j].setOpaque(true);
				numbers[i][j]=new JLabel();
                                numbers[i][j].setSize(new Dimension(10, 10));
				numbers[i][j].setText(" ");
                                numbers[i][j].setOpaque(true);
                                numbers[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                numbers[i][j].setBackground(colors[j]);
                                numbers[i][j].setForeground(colors[j]);
                                numbers[i][j].setFont(new Font("Arial Black",1,40));
                                add(numbers[i][j]);*/	
                        }
                }
                
	}
	
	private void addColors(){
		colors[0]=Color.BLACK;
		colors[1]=Color.WHITE;
                colors[2]=Color.BLACK;
		colors[3]=Color.WHITE;
                colors[4]=Color.BLACK;
		colors[5]=Color.WHITE;
                colors[6]=Color.BLACK;
		colors[7]=Color.WHITE;
	}
	
//	public static void main(String[] args) {
//		
//		
//			new TableroGrafico();
//		
//		
//		
//	}
}
