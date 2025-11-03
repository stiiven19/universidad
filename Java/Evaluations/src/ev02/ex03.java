package ev02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ex03 extends JInternalFrame{
	
	JLabel				lbselect;
	JComboBox<String>	cbTables;
	JTable				tables;
	String				spaces[];				
	DefaultTableModel	tm;
	
	public ex03() {
		super("Times Table",false,true,false,false);
		setSize(200, 220);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}

	private void setupWidgets() {
		
		spaces			= new String[10];
		for (int i = 0; i < 10; i++) {
			spaces[i]	= new String((i+1)+" Times table");
		}
		
		lbselect		= new JLabel("Select a Table");
		cbTables		= new JComboBox<String>(spaces);
		tm		= new DefaultTableModel(new Object[]{""+1,
												""+2,
				""+3,
				""+4,
				""+5},0);
		tables			= new JTable(tm);
		
		
		JPanel pnNorth	= new JPanel(new GridLayout(1,2));
		pnNorth.add(lbselect);
		pnNorth.add(cbTables);
		
		
		add(tables);
		add(pnNorth,BorderLayout.NORTH);
		
		
		
	}

	private void setupEvents() {
		
		cbTables.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (tm.getRowCount()!=0) {
					for (int i = 0; i < 10; i++) {
							tm.removeRow(0);
						}	
				}
				int index=cbTables.getSelectedIndex();
				int num =1;
				for (int i = 0; i < 10; i++) {
					Object names[] = {(index+1)+"",
												"X",
												num+"",
												"=",
												((index+1)*num)+""};
					num++;	
					tm.addRow(names);
				}
			}
		});
	}
}
