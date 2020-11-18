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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import tp.enums.EstadoCompetencia;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import tp.enums.ModalidadDePuntuacion;

public class PanelListarCompetenciasDeportivas extends JPanel {

	private Component btnConfirmar;
	private JTable tablaCompetencias;
	private JTable table;
	private JTextField textField;

	public PanelListarCompetenciasDeportivas(MainApplication m) {
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
		
		tablaCompetencias = new JTable();
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
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionBackground(new Color(51, 102, 255));
		table.setBackground(new Color(51, 102, 255));
		table.setShowVerticalLines(true);
		table.setRowHeight(20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"<", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ">"},
			},
			new String[] {
				"<", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ">"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(1).setMaxWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMaxWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setMinWidth(20);
		table.getColumnModel().getColumn(3).setMaxWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		table.getColumnModel().getColumn(4).setMaxWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setMinWidth(20);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setMinWidth(20);
		table.getColumnModel().getColumn(6).setMaxWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setMinWidth(20);
		table.getColumnModel().getColumn(7).setMaxWidth(20);
		table.getColumnModel().getColumn(8).setPreferredWidth(20);
		table.getColumnModel().getColumn(8).setMinWidth(20);
		table.getColumnModel().getColumn(8).setMaxWidth(20);
		table.getColumnModel().getColumn(9).setPreferredWidth(20);
		table.getColumnModel().getColumn(9).setMinWidth(20);
		table.getColumnModel().getColumn(9).setMaxWidth(20);
		table.getColumnModel().getColumn(10).setPreferredWidth(20);
		table.getColumnModel().getColumn(10).setMinWidth(20);
		table.getColumnModel().getColumn(10).setMaxWidth(20);
		table.getColumnModel().getColumn(11).setPreferredWidth(30);
		table.getColumnModel().getColumn(11).setMinWidth(30);
		table.getColumnModel().getColumn(11).setMaxWidth(30);
		panel_3.add(table);
		
		JSplitPane paneDetallesNuevaCompetencia = new JSplitPane();
		paneDetallesNuevaCompetencia.setDividerSize(0);
		panel_3.add(paneDetallesNuevaCompetencia);
		
		JButton btnDetalles = new JButton("Detalles");
		paneDetallesNuevaCompetencia.setLeftComponent(btnDetalles);
		
		JButton btnNuevaCompetencia = new JButton("Nueva Competencia");
		btnNuevaCompetencia.setBackground(new Color(51, 102, 255));
		paneDetallesNuevaCompetencia.setRightComponent(btnNuevaCompetencia);
		
		
		
		
		
		

	}
}
