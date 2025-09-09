package cw02_templates;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Template extends JInternalFrame {
	protected String		info;
	protected MDIFrame		fr_handle;
	
	public Template(MDIFrame fr_handle,String title, String info) {
		super(title, false, true, true, true);
		this.info		=info;
		this.fr_handle	=fr_handle;
		fr_handle.dp_mdi.add(this);
		setupLocaleEvents();
		int tx=0,ty=0;
		for (JInternalFrame child : fr_handle.dp_mdi.getAllFrames()) {
			if (child.getX()> tx) tx = child.getX();
			if (child.getY()> ty)  ty = child.getY();
		}
		this.setLocation(tx+15, ty+15);
		/*for (int i = 0; i < fr_handle.dp_mdi.getAllFrames().length; i++) {
			JInternalFrame child = fr_handle.dp_mdi.getAllFrames()[i];
		}*/
		setVisible(true);
	}

	private void setupLocaleEvents() {
		addInternalFrameListener(new InternalFrameListener() {
			
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameIconified(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeiconified(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameDeactivated(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				// TODO Auto-generated method stub
				fr_handle.lb_info.setText(info);
			}
		});
		
	}

}