package tp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class PanelHome extends JPanel {

	public PanelHome(MainApplication m) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout(0, 0));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setForeground(new Color(153, 204, 255));
		panel.setPreferredSize(new Dimension(10, 180));
		this.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
	
		
		JLabel lblNombre = new JLabel("Torneos y Competencias");
		lblNombre.setPreferredSize(new Dimension(200, 14));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 45));
		panel.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainApplication.class.getResource("/img/cup.png")));
		panel.add(lblNewLabel_1, BorderLayout.EAST);
		
		
		JTextPane txtDescripcion = new JTextPane();
		txtDescripcion.setEditable(false);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDescripcion.setPreferredSize(new Dimension(7, 50));
		this.add(txtDescripcion, BorderLayout.SOUTH);
		
		JPanel panelUser = new JPanel();
		panelUser.setPreferredSize(new Dimension(200, 10));
		this.add(panelUser, BorderLayout.EAST);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setFont(new Font("Dialog", Font.ITALIC, 16));
		txtpnUsuario.setText("Usuario: ...\r\nCorreoElectronico: ...\r\n");
		panelUser.setLayout(new BorderLayout(0, 0));
		panelUser.add(txtpnUsuario, BorderLayout.CENTER);
		
		JButton btnModificarParticipante = new JButton("Modificar");
		btnModificarParticipante.setBackground(new Color(102, 102, 255));
		btnModificarParticipante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelUser.add(btnModificarParticipante, BorderLayout.SOUTH);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setForeground(new Color(0, 0, 0));
		btnCerrarSesion.setBackground(new Color(255, 102, 102));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelUser.add(btnCerrarSesion, BorderLayout.NORTH);
		
		JPanel panelLugaresCompetenciasImagen = new JPanel();
		this.add(panelLugaresCompetenciasImagen, BorderLayout.CENTER);
		panelLugaresCompetenciasImagen.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setToolTipText("");
		panelLugaresCompetenciasImagen.add(splitPane, BorderLayout.NORTH);
		
		JButton btnLugares = new JButton("Lugares");
		btnLugares.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnLugares.setForeground(new Color(255, 255, 255));
		btnLugares.setBackground(new Color(51, 51, 51));
		splitPane.setRightComponent(btnLugares);
		
		JButton btnCompetencias = new JButton("Competencias");
		btnCompetencias.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnCompetencias.setForeground(new Color(255, 255, 255));
		btnCompetencias.addActionListener( a -> {
			m.cambiarPanel(new PanelListarCompetenciasDeportivas(m, this));
		});
		btnCompetencias.setBackground(new Color(51, 51, 51));
		splitPane.setLeftComponent(btnCompetencias);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panelLugaresCompetenciasImagen.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainApplication.class.getResource("/img/sports.png")));
		lblNewLabel.setBounds(32, 6, 1026, 361);
		panel_1.add(lblNewLabel);
	}
	
	
	

}
