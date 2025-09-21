package GridSelect;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GridSelection extends JComponent{

	int rows,cols;
	String col[],row[];
	
	
	public GridSelection(int rows, int cols, String[] col, String[] row) {
		
		this.rows = rows;
		this.cols = cols;
		this.col = col;
		this.row = row;
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
	int widht=getWidth();
	int height=getHeight();
	int x=widht/cols;
	
	for (int i = 0; i < widht+widht/rows; i+=widht/rows) {	
		for (int y = 0; y<height+height/cols; y+=height/cols) {
			g.drawRect(y, i,  height/cols,widht/rows);
		}
	}
		
	}
}
