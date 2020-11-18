package tp.GUI;



import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MainApplication extends JFrame {

	JPanel actual = new PanelHome(this);
	JPanel aux = null;
	public MainApplication() {
		initialize();
	}
	
	public void cambiarPanel(JPanel p) {
		// Este metodo se invoca cada vez que haya que cambiar de pantalla, es decir, cambiar de Panel
		Dimension d = this.getSize();
		this.remove(actual);
		this.actual = p;
		getContentPane().add(this.actual);
		this.pack();
		this.revalidate();
		this.repaint();
		this.setSize(d);
	}

	private void initialize() {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
		}
		
		//Set del tamanio
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApplication.class.getResource("/img/medal.png")));
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.getContentPane().setBackground(Color.WHITE);
		this.setBounds(100, 100, 286, 294);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		getContentPane().add(actual);
		this.pack();
		
		this.revalidate();
		this.repaint();
	}

	public JComponent getMenu() {
		return getJMenuBar();
	}
}
