package tp.GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.CompoundBorder;

import tp.clases.Competencia;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelVerCompetencia extends JPanel {
	private JTable table;
	private JPanel panelBotonesR;

	
	//Gestores
	private GestorCompetencia gestorCompetencia = new GestorCompetencia();
		
	//DTO
	private CompetenciaDTO compDTO;
	private CompetenciaPartidosDTO compPartDTO;
		
	/**
	 * Create the panel.
	 */
//	public PanelVerCompetencia(MainApplication m) {
//		initialize(m);
//	}
	
	// Corrección, entre interfaces solo podemos pasar parametros simples
	public PanelVerCompetencia(MainApplication m, Integer id_competencia) {
		initialize(m, id_competencia);
	}

	private void initialize(MainApplication m, Integer id_competencia) {
		
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
		
		compDTO = new CompetenciaDTO(id_competencia);
		compPartDTO = gestorCompetencia.mostrarCompetencia(compDTO);
		
		setBackground(new Color(102, 102, 102));
		m.setTitle("");
		setBounds(100, 50, 1280, 720);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelDown = new JPanel();
		panelDown.setPreferredSize(new Dimension(10, 210));
		panelDown.setBackground(new Color(102, 102, 102));
		add(panelDown, BorderLayout.SOUTH);
		
		JPanel panelBotonesL = new JPanel();
		panelBotonesL.setBackground(new Color(102, 102, 102));
		
		panelBotonesR = new JPanel();
		panelBotonesR.setBackground(new Color(102, 102, 102));
		panelBotonesR.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVerTablaDePosiciones = new JButton("Ver Tabla de Posiciones");
		btnVerTablaDePosiciones.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesR.add(btnVerTablaDePosiciones);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesR.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnEliminar.setBackground(new Color(204, 0, 0));
		panelBotonesR.add(btnEliminar);
		GroupLayout gl_panelDown = new GroupLayout(panelDown);
		gl_panelDown.setHorizontalGroup(
			gl_panelDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDown.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelBotonesL, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelBotonesR, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelDown.setVerticalGroup(
			gl_panelDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDown.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelDown.createSequentialGroup()
						.addContainerGap()
						.addComponent(panelBotonesR, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addGroup(Alignment.LEADING, gl_panelDown.createSequentialGroup()
						.addContainerGap()
						.addComponent(panelBotonesL, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
		);
		panelBotonesL.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVerParticipantes = new JButton("Ver Participantes");
		btnVerParticipantes.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesL.add(btnVerParticipantes);
		
		btnVerParticipantes.addActionListener( a -> {
			m.cambiarPanel(new PanelListarParticipantes(m, this, id_competencia));
		});
		
		JButton btnGenerarFixture = new JButton("Generar Fixture");
		btnGenerarFixture.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesL.add(btnGenerarFixture);
		
		JButton btnVerFixture = new JButton("Ver Fixture");
		btnVerFixture.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnVerFixture.setBackground(new Color(51, 102, 255));
		btnVerFixture.setForeground(new Color(0, 0, 0));
		
		// Si el fixture no está creado, se bloquea el botón
		if(!compPartDTO.isCreated()) {
			btnVerFixture.setEnabled(false);
		}
		
		
		// Logica de botones
		btnVerTablaDePosiciones.addActionListener( a -> {
			//m.cambiarPanel(new PanelTablaDePosiciones(m, id_competencia));
		});
		
		btnModificar.addActionListener( a -> {
			//m.cambiarPanel(new PanelModificarCompetencia(m, id_competencia));
		});
		
		btnEliminar.addActionListener( a -> {
			//m.cambiarPanel(new PanelEliminarCompetencia(m, id_competencia));
		});
		
		btnVerParticipantes.addActionListener( a -> {
			m.cambiarPanel(new PanelListarParticipantes(m, id_competencia));
		});
		
		btnGenerarFixture.addActionListener( a -> {
			//m.cambiarPanel(new PanelGenerarFixture(m, id_competencia));
		});
		
		btnVerFixture.addActionListener( a -> {
			//m.cambiarPanel(new PanelVerFixture(m, id_competencia));
		});
		
		panelBotonesL.add(btnVerFixture);
		panelDown.setLayout(gl_panelDown);
		
		JPanel panelUp = new JPanel();
		panelUp.setBackground(new Color(102, 102, 102));
		add(panelUp, BorderLayout.NORTH);
		
		JPanel panelNombreCompetencia = new JPanel();
		panelNombreCompetencia.setBackground(new Color(153, 204, 255));
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		
		JPanel panelNombreEncuentro = new JPanel();
		panelNombreEncuentro.setBackground(Color.BLACK);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panelUp = new GroupLayout(panelUp);
		gl_panelUp.setHorizontalGroup(
			gl_panelUp.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelUp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUp.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCentral, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
						.addComponent(panelNombreCompetencia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
						.addComponent(panelNombreEncuentro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelUp.setVerticalGroup(
			gl_panelUp.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelUp.createSequentialGroup()
					.addGap(15)
					.addComponent(panelNombreCompetencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNombreEncuentro, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCentral, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PanelVerCompetencia.class.getResource("/img/marca.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Modalidad: " + compPartDTO.getModalidad());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1_1 = new JLabel("Deporte: " + compPartDTO.getDeporte());
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(PanelVerCompetencia.class.getResource("/img/marca.png")));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(PanelVerCompetencia.class.getResource("/img/marca.png")));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Estado: " + compPartDTO.getEstado());
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblNewLabel_3 = new JLabel("Proximos Encuentros");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addGap(23)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addGap(40)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCentral.createSequentialGroup()
									.addGap(41)
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
		panelNombreCompetencia.setLayout(new BoxLayout(panelNombreCompetencia, BoxLayout.X_AXIS));

		JLabel lblNombreCompetencia = new JLabel("Competencia");
		if(compPartDTO.getNombre()!=null) lblNombreCompetencia.setText(compPartDTO.getNombre()); 
		lblNombreCompetencia.setForeground(new Color(0, 0, 0));
		lblNombreCompetencia.setFont(new Font("Tahoma", Font.BOLD, 35));
		panelNombreCompetencia.add(lblNombreCompetencia);
		panelUp.setLayout(gl_panelUp);
		
		
	}
}
