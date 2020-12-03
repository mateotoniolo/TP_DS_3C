package tp.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.Gestores.GestorCompetencia;
import tp.clases.Competencia;
import tp.enums.EstadoCompetencia;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.List;

import tp.enums.ModalidadDePuntuacion;

public class PanelListarCompetenciasDeportivas extends JPanel {

	private Component btnConfirmar;
	private JTable tablaCompetencias;
	private JTextField textField;

	public PanelListarCompetenciasDeportivas(MainApplication m, PanelHome panelHome) {
		initialize(m);
	}

	private void initialize(MainApplication m) {
		
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
		
		setBackground(new Color(102, 102, 102));
		m.setTitle("BUSCAR COMPETENCIA");
		setBounds(100, 50, 1280, 720);
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 230));
		panel.setBackground(new Color(102, 102, 102));
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 204, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(7, Short.MAX_VALUE))
		);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(13, 30));
		textField.setFont(UIManager.getFont("TextArea.font"));
		textField.setColumns(10);
		
		JComboBox boxModalidad = new JComboBox();
		boxModalidad.setModel(new DefaultComboBoxModel(ModalidadDePuntuacion.values()));
		boxModalidad.setPreferredSize(new Dimension(33, 30));
		boxModalidad.setFont(UIManager.getFont("CheckBox.font"));
		
		JComboBox boxDeporte = new JComboBox();
		boxDeporte.setModel(new DefaultComboBoxModel(new String[] {"---Seleccionar---"}));
		boxDeporte.setPreferredSize(new Dimension(33, 30));
		boxDeporte.setFont(UIManager.getFont("CheckBox.font"));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JSplitPane paneBuscarSalir = new JSplitPane();
		paneBuscarSalir.setDividerSize(0);
		
		JButton btnBuscar = new JButton("Buscar");
		paneBuscarSalir.setLeftComponent(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		paneBuscarSalir.setRightComponent(btnSalir);
		
		JComboBox boxEstado = new JComboBox();
		boxEstado.setModel(new DefaultComboBoxModel(EstadoCompetencia.values()));
		boxEstado.setPreferredSize(new Dimension(33, 30));
		boxEstado.setFont(UIManager.getFont("CheckBox.font"));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(198)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblModalidad, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(411)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(boxDeporte, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(boxEstado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(739)
							.addComponent(paneBuscarSalir)))
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModalidad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(boxDeporte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(boxEstado, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(paneBuscarSalir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollTablaCompetencias = new JScrollPane();
		scrollTablaCompetencias.setBackground(new Color(255, 255, 255));
		add(scrollTablaCompetencias, BorderLayout.CENTER);
		
//		List<CompetenciaDTO> competencias = GestorCompetencia.listarCompetencias();
		Integer i=0;
		Object[][] rows = null;
//		for(CompetenciaDTO unaFila : competencias) {
//			rows[i][0] = unaFila.getNombre();
//			rows[i][0] = unaFila.getId_deporte();
//			rows[i][0] = unaFila.getModalidad().toString();
//			rows[i][0] = null/*unaFila.getEstado()*/;
//			i++;
//		}
		
		tablaCompetencias = new JTable();
		tablaCompetencias.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Deporte", "Modalidad", "Estado"
			}
		));
		tablaCompetencias.setSelectionBackground(new Color(102, 51, 255));
		tablaCompetencias.setGridColor(Color.WHITE);
		scrollTablaCompetencias.setViewportView(tablaCompetencias);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 10));
		panel_1.setBackground(new Color(102, 102, 102));
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200, 10));
		panel_2.setBackground(new Color(102, 102, 102));
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 102));
		panel_3.setPreferredSize(new Dimension(10, 50));
		add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSplitPane paneDetallesNuevaCompetencia = new JSplitPane();
		paneDetallesNuevaCompetencia.setDividerSize(0);
		panel_3.add(paneDetallesNuevaCompetencia);
		
		JButton btnDetalles = new JButton("Detalles");
		paneDetallesNuevaCompetencia.setLeftComponent(btnDetalles);
		
		btnDetalles.addActionListener( a -> {
//			TODO distinguir competencia 
//			tablaCompetencias.getSelectedRow());
			
//			m.cambiarPanel(new PanelVerCompetencia(m, new Competencia()));
		});
		
		JButton btnNuevaCompetencia = new JButton("Nueva Competencia");
		btnNuevaCompetencia.setBackground(new Color(51, 102, 255));
		paneDetallesNuevaCompetencia.setRightComponent(btnNuevaCompetencia);
		
		btnNuevaCompetencia.addActionListener( a -> {
			m.cambiarPanel(new PanelAltaCompetencia(m));
		});
		
		
		
		

	}
}
