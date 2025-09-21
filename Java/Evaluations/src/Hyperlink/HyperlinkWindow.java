package Hyperlink;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/// Complete here

public class HyperlinkWindow extends JFrame {
	
	private HyperLink 	ct_choir,ct_verse1,ct_verse2,ct_verse3;
	private JTextArea	ta_info;
	//----------------------------------------------------------
	public HyperlinkWindow() {
		super("Hyperlink Test");
		setSize(400,200);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//----------------------------------------------------------
	private void setupWidgets() {
		
		ct_choir  = new HyperLink("Choir");ct_choir.setPreferredSize(new Dimension(70,20));ct_choir.setCursor(new Cursor(HAND_CURSOR));
		ct_verse1 = new HyperLink("Verse 1");ct_verse1.setCursor(new Cursor(HAND_CURSOR));
		ct_verse2 = new HyperLink("Verse 2");ct_verse2.setCursor(new Cursor(HAND_CURSOR));
		ct_verse3 = new HyperLink("Verse 3");ct_verse3.setCursor(new Cursor(HAND_CURSOR));
		JPanel pn_west = new JPanel(new GridLayout(4,1));
		
		pn_west.add(ct_choir);
		pn_west.add(ct_verse1);
		pn_west.add(ct_verse2);
		pn_west.add(ct_verse3);
		
		
		add(pn_west,BorderLayout.WEST);
		add(ta_info = new JTextArea());
		
		
	}
	//----------------------------------------------------------
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ct_choir.addHyperLinkListener(new HyperLinkListener() {
			
			@Override
			public void linkTaked() {
				ta_info.setText("Oh, gloria inmarcesible!\n" + 
						"Oh, jubilo inmortal!\n" + 
						"En surcos de dolores\n" + 
						"El bien germina ya!");
			}
		});

		ct_verse1.addHyperLinkListener(new HyperLinkListener() {
			
			@Override
			public void linkTaked() {
				ta_info.setText("Ceso la horrible noche!\n" + 
						"La libertad sublime\n" + 
						"Derrama las auroras\n" + 
						"De su invencible luz.\n" + 
						"La humanidad entera,\n" + 
						"Que entre cadenas gime,\n" + 
						"Comprende las palabras\n" + 
						"Del que murió en la cruz.");
			}
		});

		ct_verse2.addHyperLinkListener(new HyperLinkListener() {
			
			@Override
			public void linkTaked() {
				ta_info.setText("«¡Independencia!» grita\n" + 
						"El mundo americano;\n" + 
						"Se baña en sangre de héroes\n" + 
						"La tierra de Colón.\n" + 
						"Pero este gran principio:\n" + 
						"«El rey no es soberano»,\n" + 
						"Resuena, y los que sufren\n" + 
						"Bendicen su pasión.");
			}
		});

		ct_verse3.addHyperLinkListener(new HyperLinkListener() {
			
			@Override
			public void linkTaked() {
				ta_info.setText("Del Orinoco el cauce\n" + 
						"Se colma de despojos;\n" + 
						"De sangre y llanto y un río\n" + 
						"Se mira allí correr.\n" + 
						"En Bárbula no saben\n" + 
						"Las almas ni los ojos\n" + 
						"Si admiración o espanto\n" + 
						"Sentir o padecer.");
			}
		});

	
	}
	//----------------------------------------------------------
	public static void main(String[] args) {
		new HyperlinkWindow();
	}
}
