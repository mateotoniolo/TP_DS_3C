package tp.GUI;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.Gestores.GestorCompetencia;
import tp.Gestores.GestorUsuario;
import tp.app.App;
import tp.enums.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelAltaCompetencia extends JPanel {
	

	private Integer id_deporte;
	private String nombreCompetencia;
	private tp.enums.Modalidad modalidadCompetencia;
	private String reglamentoCompetencia;
	private Integer cantSets = null;
	private ModalidadDePuntuacion puntuacion;
	private Double tantosXAusencia;
	private Boolean empate = false;
	private Double puntosPartidoGanado = null;
	private Double puntosPresentarse = null;
	private Double puntosEmpate = null;
	private Integer id_usuario = 6;
	
	//Gestores
	private GestorCompetencia gestorCompetencia = new GestorCompetencia();
	
	//DTO
	private CompetenciaDTO compDTO ;
	
	//Aqui se definen los componentes del Panel
	private JTextField txtNombre;
	private JTextField txtCantidadSets;
	private JTextField txtTantosAusencia;
	private JTextField txtPuntosPartidoGanado;
	private JTextField txtPuntosEmpate;
	private JTextField txtPuntosPresentarse;
	private JComboBox<Modalidad> boxModalidad;
	private JComboBox<String> boxDeporte_1;
	private JRadioButton rdbtnSets;
	private JRadioButton rdbtnPuntuacion;
	private JRadioButton rdbtnPuntuacionFinal;
	private JRadioButton rdbtnEmpate;
	private JButton btnConfirmar; 
	private JButton btnModificarLugar;
	private JTable tableLugares;
	private JFrame frame;

	//Define el Table model
	AltaCompetenciaTM tableModel  = new AltaCompetenciaTM();

	public PanelAltaCompetencia(MainApplication m, JPanel llamante) {
		initialize(m, llamante);
	}

	private void initialize(MainApplication m, JPanel llamante) {
		frame = m;
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
		m.setTitle("ALTA COMPETENCIA");
		m.setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 50, 1366, 740);
		
		//Modelo del box deporte

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
		Vector model = new Vector();
		model.addElement(new Item(-1,"----Seleccionar----"));
		for(DeporteDTO d : GestorCompetencia.getDeportes()) {
			model.addElement(new Item(d.getId_deporte(),d.getNombre()));
		}
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setBackground(new Color(153, 204, 255));
		add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(new Color(204, 204, 204));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		tableLugares = new JTable();	
		tableLugares.setModel(tableModel);	//tableModel se define arriba en los atributos
		tableLugares.getColumnModel().getColumn(0).setResizable(false);
		tableLugares.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableLugares.getColumnModel().getColumn(1).setResizable(false);
		tableLugares.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(tableLugares);
		tableLugares.setAutoCreateRowSorter(true);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		txtNombre = new JTextField();
		txtNombre.setMinimumSize(new Dimension(15, 28));
		txtNombre.setPreferredSize(new Dimension(15, 30));
		txtNombre.setColumns(10);
		
		txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				txtNombre.setText(txtNombre.getText().toUpperCase());

				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
				}

			}
		});
		
		JLabel lblDeporte = new JLabel("Deporte *");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		boxDeporte_1= new JComboBox( model );
		boxDeporte_1.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		boxDeporte_1.addActionListener( a -> {
		this.tableModel.vaciarTabla(); //En caso de cambiar de deporte vac�a la tabla
		this.tableLugares.updateUI();
		id_deporte = ((Item)this.boxDeporte_1.getSelectedItem()).getId();
		       });
		
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		//JBox modalidad
		boxModalidad = new JComboBox<Modalidad>();
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"----Seleccionar----", "Liga", "Eliminacion Simple", "Eliminacion Doble"}));
		
		boxModalidad.addActionListener( a -> {// habilita las entradas de puntuacion
			if(boxModalidad.getSelectedItem()=="Liga") {
				txtPuntosPartidoGanado.setEnabled(true);
				txtPuntosPresentarse.setEnabled(true);
				rdbtnEmpate.setEnabled(true);
				txtTantosAusencia.setEnabled(true);
			} else {
				txtPuntosPartidoGanado.setEnabled(false);
				txtPuntosPartidoGanado.setText("");
				txtPuntosPresentarse.setEnabled(false);
				txtPuntosPresentarse.setText("");
				rdbtnEmpate.setEnabled(false);
				rdbtnEmpate.setSelected(false);
				txtPuntosEmpate.setText("");
				txtPuntosEmpate.setEnabled(false);

			}
			if(boxModalidad.getSelectedItem()=="----Seleccionar----") {
				txtTantosAusencia.setEnabled(false);
			} else {
				txtTantosAusencia.setEnabled(true);
			}
		});
		
		rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setFont(new Font("SansSerif", Font.PLAIN, 16));
		rdbtnEmpate.setEnabled(false);
		
		rdbtnEmpate.addActionListener( a -> {
			if (rdbtnEmpate.isSelected()) {
				txtPuntosEmpate.setEnabled(true);
				empate = true;
			} else {
				txtPuntosEmpate.setEnabled(false);
				txtPuntosEmpate.setText("");
				empate = false;
			}			
		});
		
		JLabel lblPuntosPartidoGanado = new JLabel("Puntos por Partido Ganado");
		lblPuntosPartidoGanado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtPuntosPartidoGanado = new JTextField();
		txtPuntosPartidoGanado.setEnabled(false);
		txtPuntosPartidoGanado.setColumns(10);
		
		//ignora el ingreso de caracteres no numericos
		txtPuntosPartidoGanado.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) { // TODO Falta Capturar la exception cuando esta vacio
					txtPuntosPartidoGanado.setText(reparse(txtPuntosPartidoGanado.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtPuntosPartidoGanado.setText(txtPuntosPartidoGanado.getText());
				}
			}
		});
		
		JLabel lblPuntosPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPresentarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtPuntosPresentarse = new JTextField();
		txtPuntosPresentarse.setEnabled(false);
		txtPuntosPresentarse.setColumns(10);
		
		//ignora el ingreso de caracteres no numericos
		txtPuntosPresentarse.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtPuntosPresentarse.setText(reparse(txtPuntosPresentarse.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtPuntosPresentarse.setText(reparse(txtPuntosPresentarse.getText()));
				}
			} 
		});
		
		JLabel lblPuntosEmpate = new JLabel("Puntos por Empate");
		lblPuntosEmpate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		txtPuntosEmpate = new JTextField();
		txtPuntosEmpate.setEnabled(false);
		txtPuntosEmpate.setColumns(10);
		
		//ignora el ingreso de caracteres no numericos
		txtPuntosEmpate.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtPuntosEmpate.setText(reparse(txtPuntosEmpate.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtPuntosEmpate.setText(txtPuntosEmpate.getText());
				}
				

				
			} 
		});
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		
		JLabel lblFormaPuntuacion = new JLabel("Forma de Puntuaci\u00F3n *");
		lblFormaPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		rdbtnSets = new JRadioButton("Sets");
		rdbtnSets.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		rdbtnSets.addActionListener( a -> {
			rdbtnPuntuacion.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(true);
			
			if(!rdbtnPuntuacion.isSelected() && !rdbtnPuntuacionFinal.isSelected()) {
				rdbtnSets.setSelected(true);
			}
			if(rdbtnSets.isSelected()) {
				txtCantidadSets.setEnabled(true);
			} else {
				txtCantidadSets.setEnabled(false);
			}
		});
		
		rdbtnPuntuacion = new JRadioButton("Puntuaci\u00F3n");
		rdbtnPuntuacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacion.setSelected(true);
		
		rdbtnPuntuacion.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
			
			if(!rdbtnSets.isSelected() && !rdbtnPuntuacionFinal.isSelected()) {
				rdbtnPuntuacion.setSelected(true);
			}
		});
		
		rdbtnPuntuacionFinal = new JRadioButton("Puntuaci\u00F3n Final");
		rdbtnPuntuacionFinal.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		rdbtnPuntuacionFinal.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacion.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
			txtTantosAusencia.setText("");
			
			if(!rdbtnSets.isSelected() && !rdbtnPuntuacion.isSelected()) {
				rdbtnPuntuacionFinal.setSelected(true);
			}
		});
		
				
		JLabel lblCantidadSets = new JLabel("Cantidad de Sets ");
		lblCantidadSets.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
		//Indica cantidad de sets
		txtCantidadSets = new JTextField();
		txtCantidadSets.setColumns(10);
		txtCantidadSets.setEnabled(false);
		
		txtCantidadSets.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtCantidadSets.setText(reparse(txtCantidadSets.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtCantidadSets.setText(txtCantidadSets.getText());
				}}

		});
		
		JLabel lblCantidadTantos = new JLabel("Tantos por ausencia");
		lblCantidadTantos.setToolTipText("");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
				
		txtTantosAusencia = new JTextField();
		txtTantosAusencia.setEnabled(false);
		txtTantosAusencia.setColumns(10);
				
		//ignora el ingreso de caracteres no numericos
		txtTantosAusencia.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						Character c = e.getKeyChar();
						if(!Character.isDigit(c)) {
							txtTantosAusencia.setText(reparse(txtTantosAusencia.getText()));
						}
						
						int code=e.getKeyCode();
						if(code==KeyEvent.VK_BACK_SPACE) {
							txtTantosAusencia.setText(txtTantosAusencia.getText());
						}

					}
				});
		
				
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JTextArea txtReglamento = new JTextArea();
		txtReglamento.setMaximumSize(new Dimension(100, 100));
		scrollPane_1.setViewportView(txtReglamento);
		
		JButton btnEliminarLugar = new JButton("Eliminar Lugar");
		btnEliminarLugar.setPreferredSize(new Dimension(80, 28));
		btnEliminarLugar.addActionListener(a -> {
			try {
			ItemLugarDTO p = this.tableModel.getData()
	                .stream()
	                .filter(item -> item.getCodigo() == this.tableModel.getValueAt(this.tableLugares.getSelectedRow(), 0))
	                .findFirst()
	                .get();
			this.tableModel.remove(p);
			this.tableLugares.updateUI();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un lugar a eliminar.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}
		});
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		btnAgregarLugar.setPreferredSize(new Dimension(100, 28));
		
		btnAgregarLugar.addActionListener( a -> {
			id_deporte = ((Item)this.boxDeporte_1.getSelectedItem()).getId();
			if(id_deporte == -1) {
				JOptionPane.showMessageDialog(null, "No hay Deporte seleccionado. Debe seleccionar un Deporte para agregar un Lugar.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}else {
				if(GestorUsuario.getLugaresDisponibles(id_usuario, ((Item)this.boxDeporte_1.getSelectedItem()).getId()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "No existe Lugar que acepte el Deporte seleccionado.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
				}else {
					DialogAltaLugar dialogAltaLugar = new DialogAltaLugar(this);
				}
			}
		});
		
		btnModificarLugar = new JButton("Modificar Lugar");
		btnModificarLugar.setPreferredSize(new Dimension(100, 28));
		btnModificarLugar.addActionListener(a -> {
			try {
				ItemLugarDTO p = this.tableModel.getData()
		                .stream()
		                .filter(item -> item.getCodigo() == this.tableModel.getValueAt(this.tableLugares.getSelectedRow(), 0))
		                .findFirst()
		                .get();
				DialogModificarLugar modificar = new DialogModificarLugar(this, p);
				
				this.tableLugares.updateUI();
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un lugar a modificar.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
				}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtPuntosPartidoGanado, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblPuntosPartidoGanado, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtPuntosPresentarse, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblPuntosPresentarse, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblDeporte, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblModalidad, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
											.addGap(36))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(boxDeporte_1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPuntosEmpate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(27)
											.addComponent(rdbtnEmpate, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(18)
											.addComponent(lblPuntosEmpate, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))))
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnSets, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtCantidadSets, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblCantidadSets, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtTantosAusencia, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblCantidadTantos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(rdbtnPuntuacion, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnPuntuacionFinal, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblFormaPuntuacion, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblReglamento, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
							.addGap(42))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAgregarLugar, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(btnModificarLugar, GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE)
							.addGap(3)
							.addComponent(btnEliminarLugar, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
					.addGap(6))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModalidad))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(boxDeporte_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(boxModalidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnEmpate, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addGap(13)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPuntosPartidoGanado, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPuntosPresentarse, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPuntosEmpate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPuntosPartidoGanado, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPuntosPresentarse, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPuntosEmpate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addGap(17)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(lblFormaPuntuacion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnSets, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnPuntuacion, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnPuntuacionFinal, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCantidadSets, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCantidadTantos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCantidadSets, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTantosAusencia, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addGap(23)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(lblReglamento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAgregarLugar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificarLugar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminarLugar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(54))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelUp = new JPanel();
		panelUp.setBackground(new Color(102, 102, 102));
		panelUp.setPreferredSize(new Dimension(10, 86));
		add(panelUp, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		GroupLayout gl_panelUp = new GroupLayout(panelUp);
		gl_panelUp.setHorizontalGroup(
			gl_panelUp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUp.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1348, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelUp.setVerticalGroup(
			gl_panelUp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUp.createSequentialGroup()
					.addGap(5)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNuevaCompetencia = new JLabel("Nueva Competencia");
		lblNuevaCompetencia.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel_1.add(lblNuevaCompetencia, BorderLayout.WEST);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(PanelAltaCompetencia.class.getResource("/img/home.png")));
		panel_1.add(btnHome, BorderLayout.EAST);
		panelUp.setLayout(gl_panelUp);
		
		btnHome.addActionListener( a -> {
			m.cambiarPanel(new PanelHome(m));
		});
		
		JPanel panelDown = new JPanel();
		panelDown.setPreferredSize(new Dimension(10, 50));
		panelDown.setBackground(new Color(102, 102, 102));
		add(panelDown, BorderLayout.SOUTH);
		
				
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(true);
		btnConfirmar.setBackground(new Color(51, 102, 255));
						
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setDividerSize(0);
						
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener( a -> {
			m.cambiarPanel(llamante);
		});
		splitCancelarConfirmar.setRightComponent(btnConfirmar);
		splitCancelarConfirmar.setLeftComponent(btnAtras);
		GroupLayout gl_panelDown = new GroupLayout(panelDown);
						gl_panelDown.setHorizontalGroup(
							gl_panelDown.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panelDown.createSequentialGroup()
									.addContainerGap(1191, Short.MAX_VALUE)
									.addComponent(splitCancelarConfirmar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
						);
						gl_panelDown.setVerticalGroup(
							gl_panelDown.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDown.createSequentialGroup()
									.addContainerGap()
									.addComponent(splitCancelarConfirmar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(14, Short.MAX_VALUE))
						);
						panelDown.setLayout(gl_panelDown);
						
						
		//Al confirmar, se asignan todos los valores ingresados
		btnConfirmar.addActionListener( a -> {
			nombreCompetencia = txtNombre.getText();
			
			try {
				cantSets = Integer.parseInt(txtCantidadSets.getText());
			}
			catch(Exception e) {
				cantSets = null;
			}
			try {
			tantosXAusencia = Double.parseDouble(txtTantosAusencia.getText());
			}
			catch(Exception e) {
				tantosXAusencia = null;
			}
			try {
			puntosPartidoGanado = Double.parseDouble(txtPuntosPartidoGanado.getText());
			}
			catch(Exception e) {
				puntosPartidoGanado = null;
			}
			try {
			puntosEmpate = Double.parseDouble(txtPuntosEmpate.getText());
			} 
			catch(Exception e) {
				puntosEmpate = null;
			}
			try {
			puntosPresentarse = Double.parseDouble(txtPuntosPresentarse.getText());
			}
			catch(Exception e) {
				puntosPresentarse = null;
			}
			if(this.rdbtnEmpate.isSelected()) {
				this.empate =true;
				try {
				this.puntosEmpate = Double.parseDouble(this.txtPuntosEmpate.getText());
				}catch(Exception ex) {};
			}
			reglamentoCompetencia = txtReglamento.getText();
			
			//Set de modalidad de competencia
			switch((String)boxModalidad.getSelectedItem()) {
			case "Liga": modalidadCompetencia = tp.enums.Modalidad.LIGA;
				break;
			case "Eliminacion Simple": modalidadCompetencia = tp.enums.Modalidad.ELIMINACION_DIRECTA;
				break;
			case "Eliminacion Doble": modalidadCompetencia = tp.enums.Modalidad.ELIMINACION_DOBLE;
				break;
			default:modalidadCompetencia = null;
			}
			//Set de Modalidad de Puntuacion
			if(rdbtnSets.isSelected()) {
				this.puntuacion = ModalidadDePuntuacion.SETS;
			}else if(rdbtnPuntuacion.isSelected()) {
				this.puntuacion = ModalidadDePuntuacion.PUNTUACION;
				this.cantSets = 0;
			}else if(rdbtnPuntuacionFinal.isSelected()) {
				this.puntuacion = ModalidadDePuntuacion.PUNTUACION_FINAL;
				this.cantSets = 0;
			}
			//Set de idDeporte
			id_deporte = ((Item)this.boxDeporte_1.getSelectedItem()).getId();
			
			//Asigna valores de DTO
			//-----------------------------------------------------------------------------------------------------------------------------------------------------------
			compDTO = new CompetenciaDTO(this.nombreCompetencia,this.modalidadCompetencia, this.reglamentoCompetencia,
					this.cantSets, this.puntuacion, this.tantosXAusencia, this.empate,this.puntosPresentarse,
					this.puntosEmpate,this.puntosPartidoGanado, this.id_deporte, this.tableModel.getData(), this.id_usuario);

			try {
				String CamposVacios="";
				if(compDTO.getNombre().isEmpty()) {
					CamposVacios=CamposVacios+"La competencia debe tener un nombre. \n";
				}
				if(compDTO.getLugares().isEmpty()) {
					CamposVacios=CamposVacios+"La competencia debe tener al menos un lugar de realización. \n";
				}
				if(compDTO.getModalidad() == null) {
					CamposVacios=CamposVacios+"Debe indicar una Modalidad de competencia. \n";
				}
				if(compDTO.getModalidad()==tp.enums.Modalidad.LIGA) {
					if(compDTO.getEmpate()&&compDTO.getPuntosXEmpate()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por empate. \n";
					}
					if(compDTO.getPuntosXGanado()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por partido ganado. \n";
					}
					if(compDTO.getPuntosXPresentarse()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por presentarse. \n";
					}
				}
				switch(compDTO.getPuntuacion()) {
				case SETS:
					if(compDTO.getCantSets()==null) {
						CamposVacios=CamposVacios+"Debe ingresar una cantidad válida de sets. \n";
					}
					break;
				default:
					if(compDTO.getTantosXAusencia()==null) {
						CamposVacios=CamposVacios+"Debe ingresar tantos por ausencia. \n";
					}
				}
				if(!CamposVacios.equals("")) {
					throw new Exception("Campos incompletos: \n"+CamposVacios);
				}
				if(compDTO.getPuntuacion()==ModalidadDePuntuacion.SETS &&
						(compDTO.getCantSets()%2!=1||compDTO.getCantSets()>10)) {
					throw new Exception("La cantidad de sets no es impar o es mayor a 10.");
				}
				if(compDTO.getEmpate()&&(compDTO.getPuntosXEmpate()>compDTO.getPuntosXGanado())) {
					throw new Exception("Los puntos por empate son mayores a los puntos por ganar.");
				}
				if((compDTO.getPuntuacion() == ModalidadDePuntuacion.SETS) && (compDTO.getPuntosXPresentarse() >= compDTO.getPuntosXGanado())) {
					throw new Exception("Los puntos por presentarse son mayores a los puntos por ganar.");
				}
				
				gestorCompetencia.crearCompetencia(compDTO);

				JOptionPane.showMessageDialog(null, "La Competencia se guardo con éxito","Dar de Alta Competencia",JOptionPane.INFORMATION_MESSAGE,App.emoji("icon/correcto1.png", 32,32));
				m.cambiarPanel(new PanelListarParticipantes(m, this, GestorCompetencia.getCompetenciaByName(this.nombreCompetencia).getId_competencia()));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}
				
		});
		
		JPanel panelL = new JPanel();
		panelL.setPreferredSize(new Dimension(6, 10));
		panelL.setBackground(new Color(102, 102, 102));
		add(panelL, BorderLayout.WEST);
		
		JPanel panelR = new JPanel();
		panelR.setBackground(new Color(102, 102, 102));
		panelR.setPreferredSize(new Dimension(6, 10));
		add(panelR, BorderLayout.EAST);
		
		
		
		//TAB ORDEN
		ArrayList<Component> order = new ArrayList<Component>();
		
		setFocusCycleRoot(true);
		txtNombre.setFocusCycleRoot(true);
		boxDeporte_1.setFocusCycleRoot(true);
		boxModalidad.setFocusCycleRoot(true);
		txtPuntosPartidoGanado.setFocusCycleRoot(true);
		txtPuntosPresentarse.setFocusCycleRoot(true);
		rdbtnEmpate.setFocusCycleRoot(true);
		txtPuntosEmpate.setFocusCycleRoot(true);
		rdbtnSets.setFocusCycleRoot(true);
		rdbtnPuntuacion.setFocusCycleRoot(true);
		rdbtnPuntuacionFinal.setFocusCycleRoot(true);
		txtCantidadSets.setFocusCycleRoot(true);
		txtTantosAusencia.setFocusCycleRoot(true);
		btnAgregarLugar.setFocusCycleRoot(true);
		btnModificarLugar.setFocusCycleRoot(true);
		btnEliminarLugar.setFocusCycleRoot(true);
		btnAtras.setFocusCycleRoot(true);
		btnConfirmar.setFocusCycleRoot(true);
		btnHome.setFocusCycleRoot(true);
		
		
		order.add(txtNombre);
		order.add(boxDeporte_1);
		order.add(boxModalidad);
		order.add(txtPuntosPartidoGanado);
		order.add(txtPuntosPresentarse);
		order.add(rdbtnEmpate);
		order.add(txtPuntosEmpate);
		order.add(rdbtnSets);
		order.add(rdbtnPuntuacion);
		order.add(rdbtnPuntuacionFinal);
		order.add(txtCantidadSets);
		order.add(txtTantosAusencia);
		order.add(btnAgregarLugar);
		order.add(btnModificarLugar);
		order.add(btnEliminarLugar);
		order.add(btnAtras);
		order.add(btnConfirmar);
		order.add(btnHome);
		
		setFocusTraversalPolicy(new PanelsFocusTraversalPolicy(order, txtNombre));
		
		
	}
	
	public String reparse(String str) {
		String aux="";
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) aux+=str.charAt(i);
		}
		return aux;
	} 

	public String getDeporteCompetencia() {
		return this.boxDeporte_1.getSelectedItem().toString();
	}

	public Integer getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public void addItemTM(ItemLugarDTO item) throws Exception { // este metodo agrega el item para la tabla 
		
		try{
			this.tableModel.addItemTM(item);
		}catch(Exception e) {
			throw e;
		}
		this.tableLugares.updateUI();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

