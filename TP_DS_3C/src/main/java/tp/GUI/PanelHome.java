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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(new Color(102, 102, 102));
		panelUser.setPreferredSize(new Dimension(200, 500));
		this.add(panelUser, BorderLayout.EAST);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(0, 0, 0));
		btnIniciarSesion.setBackground(new Color(255, 102, 102));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panelUser = new GroupLayout(panelUser);
		gl_panelUser.setHorizontalGroup(
			gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_panelUser.setVerticalGroup(
			gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelUser.createSequentialGroup()
					.addContainerGap(442, Short.MAX_VALUE)
					.addComponent(btnIniciarSesion)
					.addContainerGap())
		);
		panelUser.setLayout(gl_panelUser);
		
		JPanel panelLugaresCompetenciasImagen = new JPanel();
		panelLugaresCompetenciasImagen.setBackground(Color.WHITE);
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
		panel_1.setBackground(Color.WHITE);
		panelLugaresCompetenciasImagen.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(MainApplication.class.getResource("/img/sports.png")));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(100, 80));
		panel_4.setBackground(Color.BLACK);
		add(panel_4, BorderLayout.SOUTH);
		
		JLabel lblGrupo = new JLabel("Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C");
		lblGrupo.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setBackground(Color.WHITE);
		
		JLabel lblGrupo_1 = new JLabel("Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C");
		lblGrupo_1.setForeground(new Color(153, 204, 255));
		lblGrupo_1.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblGrupo_1.setBackground(Color.WHITE);
		
		JLabel lblGrupo_1_1 = new JLabel("Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C - Grupo 3C");
		lblGrupo_1_1.setForeground(Color.WHITE);
		lblGrupo_1_1.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblGrupo_1_1.setBackground(Color.WHITE);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGrupo, GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
						.addComponent(lblGrupo_1_1, GroupLayout.PREFERRED_SIZE, 1364, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrupo_1, GroupLayout.PREFERRED_SIZE, 1364, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(1)
					.addComponent(lblGrupo_1_1)
					.addGap(1)
					.addComponent(lblGrupo_1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(lblGrupo, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
	}
}
