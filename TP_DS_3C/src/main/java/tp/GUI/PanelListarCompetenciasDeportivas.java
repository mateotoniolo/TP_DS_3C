package tp.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.Gestores.GestorCompetencia;
import tp.app.App;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import java.awt.Font;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;

public class PanelListarCompetenciasDeportivas extends JPanel {

	private ListarCompetenciasTM tableModel;
	private Integer id_usuario = 6;
	
	//elementos del panel
	private JTextField txtNombre;
	
	private JComboBox boxDeporte;
	private JComboBox<String> boxModalidad;
	private JComboBox<String> boxEstado;
	private JButton btnHome;
	private JTable tablaCompetencias;
	
	class Item
    {
        private int id;
        private String description;
 
        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }
 
        public int getId()
        {
            return id;
        }
 
        public String getDescription()
        {
            return description;
        }
 
        public String toString()
        {
            return description;
        }
    }

	public PanelListarCompetenciasDeportivas(MainApplication m, JPanel panelHome) {
		initialize(m, panelHome);
	}

	private void initialize(MainApplication m, JPanel panelHome) {
		
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
		m.setExtendedState(Frame.MAXIMIZED_BOTH);
		m.setTitle("GRUPO 3C");
		setBounds(100, 50, 1366, 740);
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 285));
		panel.setBackground(new Color(102, 102, 102));
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 204, 255));
		
		JPanel panelCompetencias = new JPanel();
		panelCompetencias.setBackground(new Color(153, 204, 255));
		
		JPanel panelNegro = new JPanel();
		panelNegro.setBackground(new Color(0, 0, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
						.addComponent(panelNegro, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
						.addComponent(panelCompetencias, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(panelCompetencias, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNegro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 168, Short.MAX_VALUE)
					.addGap(10))
		);
		panelCompetencias.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCompetencias = new JLabel("COMPETENCIAS");
		lblCompetencias.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelCompetencias.add(lblCompetencias, BorderLayout.WEST);
		
		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(PanelListarCompetenciasDeportivas.class.getResource("/img/home.png")));
		panelCompetencias.add(btnHome, BorderLayout.EAST);
		
		btnHome.addActionListener( a -> {
			m.cambiarPanel(panelHome);
		});
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(13, 30));
		txtNombre.setFont(UIManager.getFont("TextArea.font"));
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new java.awt.event.KeyAdapter() { //avanza al siguiente
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}

			}
		});
		
		boxModalidad = new JComboBox();
		boxModalidad.addItem("----Seleccionar----");
		boxModalidad.addItem(Modalidad.ELIMINACION_DIRECTA.toString());
		boxModalidad.addItem(Modalidad.ELIMINACION_DOBLE.toString());
		boxModalidad.addItem(Modalidad.LIGA.toString());
		boxModalidad.setPreferredSize(new Dimension(33, 30));
		boxModalidad.setFont(UIManager.getFont("CheckBox.font"));
		boxModalidad.addKeyListener(new java.awt.event.KeyAdapter() { //avanza al siguiente
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}

			}
		});
		
	
		Vector model = new Vector();
		model.addElement(new Item(-1,"----Seleccionar----"));
		for(DeporteDTO d : GestorCompetencia.getDeportes()) {
			model.addElement(new Item(d.getId_deporte(),d.getNombre()));
		}
		boxDeporte = new JComboBox(model);
		boxDeporte.setPreferredSize(new Dimension(33, 30));
		boxDeporte.setFont(UIManager.getFont("CheckBox.font"));
		boxDeporte.addKeyListener(new java.awt.event.KeyAdapter() { //avanza al siguiente
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}

			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		boxEstado = new JComboBox();
		boxEstado.addItem("----Seleccionar----");
		boxEstado.addItem(EstadoCompetencia.CREADA.toString());
		boxEstado.addItem(EstadoCompetencia.EN_DISPUTA.toString());
		boxEstado.addItem(EstadoCompetencia.FINALIZADA.toString());
		boxEstado.addItem(EstadoCompetencia.PLANIFICADA.toString());
		boxEstado.setPreferredSize(new Dimension(33, 30));
		boxEstado.setFont(UIManager.getFont("CheckBox.font"));
		boxEstado.addKeyListener(new java.awt.event.KeyAdapter() { //avanza al siguiente
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}

			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() { //Buscar con ENTER
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					btnBuscar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						}
					});
					btnBuscar.doClick();
				}
			}
		});
		
		
		btnBuscar.addActionListener(a -> {
			CompetenciaDTO competenciaDTO = new CompetenciaDTO();
			competenciaDTO.setNombre(this.txtNombre.getText().toString());
			if(((Item)boxDeporte.getSelectedItem()).getId() != -1) {
				competenciaDTO.setId_deporte(((Item)boxDeporte.getSelectedItem()).getId());
			}
			if(!boxModalidad.getSelectedItem().toString().equals("----Seleccionar----")) {
				competenciaDTO.setModalidad(Modalidad.valueOf(boxModalidad.getSelectedItem().toString()));
			}
			if(!boxEstado.getSelectedItem().toString().equals("----Seleccionar----")) {
				competenciaDTO.setEstado(EstadoCompetencia.valueOf(boxEstado.getSelectedItem().toString()));
			}
			competenciaDTO.setId_usuario(id_usuario);
			try {
			this.tableModel.vaciarTabla();
			for(CompetenciaDTO c : GestorCompetencia.listarCompetencias(competenciaDTO)) {
				this.tableModel.addItemTM(c);
			}
			this.tablaCompetencias.updateUI();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(198)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuscar)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblModalidad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
								.addGap(12)
								.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblDeporte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(boxDeporte, 0, 467, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
									.addComponent(boxEstado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)))))
					.addContainerGap(277, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModalidad, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(boxDeporte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(boxEstado, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(btnBuscar)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollTablaCompetencias = new JScrollPane();
		scrollTablaCompetencias.setBackground(new Color(255, 255, 255));
		add(scrollTablaCompetencias, BorderLayout.CENTER);
		
		tableModel = new ListarCompetenciasTM();
		
		tablaCompetencias = new JTable(tableModel);
		tablaCompetencias.setSelectionBackground(new Color(102, 51, 255));
		tablaCompetencias.setGridColor(Color.WHITE);
		scrollTablaCompetencias.setViewportView(tablaCompetencias);
		tablaCompetencias.setAutoCreateRowSorter(true);
		
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
		

		JButton btnNuevaCompetencia = new JButton("Nueva Competencia");
		btnNuevaCompetencia.setBackground(new Color(51, 102, 255));
		
		btnNuevaCompetencia.addActionListener( a -> {
			m.cambiarPanel(new PanelAltaCompetencia(m, this));
		});
		
		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener( a -> {
			try {
			String nombre = (String)this.tableModel.getValueAt(this.tablaCompetencias.getSelectedRow(), 0);
			DialogVerCompetencia comp = new DialogVerCompetencia(m,this, GestorCompetencia.getCompetenciaByName(nombre).getId_competencia());
			comp.setVisible(true);
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una competencia.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}
		});
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener( a -> {
			m.cambiarPanel(panelHome);
		});
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(862, Short.MAX_VALUE)
					.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDetalles)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNuevaCompetencia)
					.addGap(202))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevaCompetencia)
						.addComponent(btnDetalles)
						.addComponent(btnAtras))
					.addGap(17))
		);
		panel_3.setLayout(gl_panel_3);
		
		//TAB ORDEN
		List<Component> order = new ArrayList<Component>();
				
		setFocusCycleRoot(true);
		txtNombre.setFocusCycleRoot(true);
		boxModalidad.setFocusCycleRoot(true);
		boxDeporte.setFocusCycleRoot(true);
		boxEstado.setFocusCycleRoot(true);
		btnBuscar.setFocusCycleRoot(true);
		btnAtras.setFocusCycleRoot(true);
		btnDetalles.setFocusCycleRoot(true);
		btnNuevaCompetencia.setFocusCycleRoot(true);
		btnHome.setFocusCycleRoot(true);
				
		order.add(txtNombre);
		order.add(boxModalidad);
		order.add(boxDeporte);
		order.add(boxEstado);
		order.add(btnBuscar);
		order.add(btnAtras);
		order.add(btnDetalles);
		order.add(btnNuevaCompetencia);		
		order.add(btnHome);	
					    	    
		setFocusTraversalPolicy(new PanelsFocusTraversalPolicy(order, btnNuevaCompetencia));	
	}
	
	public void actualizar() {
		this.tablaCompetencias.updateUI();
	}
}
