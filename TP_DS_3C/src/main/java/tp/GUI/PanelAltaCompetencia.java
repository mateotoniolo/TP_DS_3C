package tp.GUI;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


import tp.DAO.*;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.Gestores.GestorCompetencia;
import tp.clases.*;
import tp.enums.*;




public class PanelAltaCompetencia extends JPanel {
	
	public enum Modalidad { LIGA, ELIMINACIONSIMPLE, ELIMINACIONDOBLE };

	//Aqui se definen los atributos de la competencia
	private String deporteCompetencia;
	private Integer id_deporte;
	private String nombreCompetencia;
	private tp.enums.Modalidad modalidadCompetencia;
	private String reglamentoCompetencia;
	private EstadoCompetencia estadoCompetencia;
	private Integer cantSets = null;
	private ModalidadDePuntuacion puntuacion;
	private Double tantosXAusencia;
	private Boolean empate = false;
	private Double puntosPartidoGanado;
	private Double puntosPresentarse;
	private Double puntosEmpate;
	private Integer id_usuario = 6;
	private Competencia competencia;
	
	//DAOs
	private CompetenciaDAO competenciaDao = new CompetenciaDAO();
	private DeporteDAO deporteDao = new DeporteDAO();
	
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
	private JComboBox<String> boxDeporte;
	private JRadioButton rdbtnSets;
	private JRadioButton rdbtnPuntuacion;
	private JRadioButton rdbtnPuntuacionFinal;
	private JRadioButton rdbtnEmpate;
	private JButton btnConfirmar; 
	private JButton btnModificarLugar;
	private JTable tableLugares;
	private boolean ingresoNombre = false;
	private boolean ingresoDeporte = false;
	private boolean ingresoModalidad = false;
	private boolean ingresoCantidadSets = false;
	private boolean ingresoTantosXAusencia = false;
	private boolean ingresoPuntosEmpate = false;
	private JFrame frame;

	//Define el Table model
	AltaCompetenciaTM tableModel  = new AltaCompetenciaTM();

	public PanelAltaCompetencia(MainApplication m) {
		initialize(m);
	}

	private void initialize(MainApplication m) {
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
		setBounds(100, 50, 1280, 720);

		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
//		btnConfirmar.setEnabled(true);
		btnConfirmar.setBackground(new Color(51, 102, 255));
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setBounds(21, 13, 141, 22);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		//Campo de texto de nombre
		txtNombre = new JTextField();
		txtNombre.setBounds(18, 31, 506, 30);
		txtNombre.setMinimumSize(new Dimension(15, 28));
		txtNombre.setPreferredSize(new Dimension(15, 30));
		txtNombre.setColumns(10);
		
		txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				txtNombre.setText(txtNombre.getText().toUpperCase());

				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
//					TODO validaciones
					ingresoNombre = (txtNombre.getText() != "");
					ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
					ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
					ingresoCantidadSets = (txtCantidadSets.getText() != "");
					ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
					ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
					
					if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
						if(rdbtnSets.isSelected()) {
							if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
							else btnConfirmar.setEnabled(false);
						} else btnConfirmar.setEnabled(true);
						
						if(boxModalidad.getSelectedItem() == "Liga") {
							if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
							else btnConfirmar.setEnabled(false);
						} else btnConfirmar.setEnabled(true);
						
						if(rdbtnEmpate.isSelected()) {
							if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
							else btnConfirmar.setEnabled(false);
						} else btnConfirmar.setEnabled(true);
						
					} else {
						btnConfirmar.setEnabled(false);
					}
				}
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(boxModalidad.getSelectedItem() == "Liga") {
						if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		
		JLabel lblDeporte = new JLabel("Deporte *");
		lblDeporte.setBounds(21, 69, 104, 25);
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//JBox de deporte
		boxDeporte = new JComboBox<String>();

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
 
 
        boxDeporte= new JComboBox( model );
        boxDeporte.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        boxDeporte.setBounds(20, 96, 232, 30);
		boxDeporte.addActionListener( a -> {
			this.tableModel.vaciarTabla(); //En caso de cambiar de deporte vac�a la tabla
			this.tableLugares.updateUI();
			btnModificarLugar.setEnabled(false);
			id_deporte = ((Item)this.boxDeporte.getSelectedItem()).getId();
//			TODO validaciones
			ingresoNombre = (txtNombre.getText() != "");
			ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
			ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
			ingresoCantidadSets = (txtCantidadSets.getText() != "");
			ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
			ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
			
			if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
				if(rdbtnSets.isSelected()) {
					if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
					else btnConfirmar.setEnabled(false);
				} else btnConfirmar.setEnabled(true);
				
				if(boxModalidad.getSelectedItem() == "Liga") {
					if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
					else btnConfirmar.setEnabled(false);
				} else btnConfirmar.setEnabled(true);
				
				if(rdbtnEmpate.isSelected()) {
					if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
					else btnConfirmar.setEnabled(false);
				} else btnConfirmar.setEnabled(true);
				
			} else {
				btnConfirmar.setEnabled(false);
			}
		});
		
		
		JLabel lblModalidad = new JLabel("Modalidad *");
		lblModalidad.setBounds(264, 69, 105, 22);
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		//JBox modalidad
		boxModalidad = new JComboBox<Modalidad>();
		boxModalidad.setBounds(264, 96, 273, 30);
		boxModalidad.setModel(new DefaultComboBoxModel(new String[] {"----Seleccionar----", "Liga", "Eliminacion Simple", "Eliminacion Doble"}));
		
		boxModalidad.addActionListener( a -> {// habilita las entradas de puntuacion
			if(boxModalidad.getSelectedItem()=="Liga") {

				btnConfirmar.setEnabled(false);
				txtPuntosPartidoGanado.setEnabled(true);
				txtPuntosPresentarse.setEnabled(true);
				rdbtnEmpate.setEnabled(true);
				txtTantosAusencia.setEnabled(true);
			} else {
				txtPuntosPartidoGanado.setEnabled(false);
				txtPuntosPartidoGanado.setText("");
				txtPuntosPresentarse.setEnabled(false);
				txtPuntosPresentarse.setText("");
				txtTantosAusencia.setEnabled(true);
				txtTantosAusencia.setText("");
				rdbtnEmpate.setEnabled(false);
				rdbtnEmpate.setSelected(false);
				txtPuntosEmpate.setText("");
				txtPuntosEmpate.setEnabled(false);
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) {
							btnConfirmar.setEnabled(true);
						}
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) {	
							btnConfirmar.setEnabled(true);
						}
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		
		JLabel lblFormaPuntuacion = new JLabel("Forma de Puntuaci\u00F3n");
		lblFormaPuntuacion.setBounds(21, 224, 179, 30);
		lblFormaPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 18));

		
		JLabel lblCantidadSets = new JLabel("Cantidad de Sets ");
		lblCantidadSets.setBounds(21, 307, 141, 30);
		lblCantidadSets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//Indica cantidad de sets
		txtCantidadSets = new JTextField();
		txtCantidadSets.setBounds(174, 311, 40, 26);
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
				}
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(boxModalidad.getSelectedItem() == "Liga") {
						if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});

		
		txtTantosAusencia = new JTextField();
		txtTantosAusencia.setBounds(456, 311, 40, 26);
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
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "");
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					
					if(ingresoTantosXAusencia) {
						btnConfirmar.setEnabled(true);
					}
					else btnConfirmar.setEnabled(false);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setBounds(21, 387, 104, 30);
		lblReglamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPuntosPartidoGanado = new JLabel("Puntos por Partido Ganado");
		lblPuntosPartidoGanado.setBounds(21, 156, 231, 21);
		lblPuntosPartidoGanado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtPuntosPartidoGanado = new JTextField();
		txtPuntosPartidoGanado.setBounds(243, 155, 40, 26);
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
		
		JLabel lblPuntosEmpate = new JLabel("Puntos por Empate");
		lblPuntosEmpate.setBounds(560, 155, 165, 24);
		lblPuntosEmpate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		txtPuntosEmpate = new JTextField();
		txtPuntosEmpate.setBounds(724, 156, 40, 26);
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
				
//				TODO validaciones
				ingresoNombre = (txtNombre.getText() != "");
				ingresoDeporte = (boxDeporte.getSelectedItem() != "----Seleccionar----");
				ingresoModalidad = ( boxModalidad.getSelectedItem() != "----Seleccionar----" );
				ingresoCantidadSets = (txtCantidadSets.getText() != "");
				ingresoPuntosEmpate = (txtPuntosEmpate.getText() != "");
				ingresoTantosXAusencia = ( txtTantosAusencia.getText() != "" );
				
				if(ingresoNombre && ingresoDeporte && ingresoModalidad) {
					if(rdbtnSets.isSelected()) {
						if(ingresoCantidadSets) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(boxModalidad.getSelectedItem() == "Liga") {
						if(ingresoTantosXAusencia) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
					if(rdbtnEmpate.isSelected()) {
						if(ingresoPuntosEmpate) btnConfirmar.setEnabled(true);
						else btnConfirmar.setEnabled(false);
					} else btnConfirmar.setEnabled(true);
					
				} else {
					btnConfirmar.setEnabled(false);
				}
				
			} 
		});
		
		rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setBounds(559, 130, 89, 23);
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
		
		JLabel lblPuntosPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPresentarse.setBounds(295, 158, 194, 19);
		lblPuntosPresentarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtPuntosPresentarse = new JTextField();
		txtPuntosPresentarse.setBounds(484, 156, 40, 26);
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
		
		rdbtnSets = new JRadioButton("Sets");
		rdbtnSets.setBounds(21, 260, 104, 18);
		rdbtnSets.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		rdbtnPuntuacion = new JRadioButton("Puntuacion");
		rdbtnPuntuacion.setBounds(291, 260, 115, 18);
		rdbtnPuntuacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnPuntuacion.setSelected(true);
		
		rdbtnPuntuacionFinal = new JRadioButton("Puntuacion Final");
		rdbtnPuntuacionFinal.setBounds(560, 260, 175, 18);
		rdbtnPuntuacionFinal.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		rdbtnSets.addActionListener( a -> {
			rdbtnPuntuacion.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(true);
			txtTantosAusencia.setText("");
			
			if(!rdbtnPuntuacion.isSelected() && !rdbtnPuntuacionFinal.isSelected()) {
				rdbtnSets.setSelected(true);
			}
		});
		
		rdbtnPuntuacion.addActionListener( a -> {
			rdbtnSets.setSelected(false);
			rdbtnPuntuacionFinal.setSelected(false);
			txtCantidadSets.setEnabled(false);
			txtCantidadSets.setText("");
			
			if(!rdbtnSets.isSelected() && !rdbtnPuntuacionFinal.isSelected()) {
				rdbtnPuntuacion.setSelected(true);
			}
		});
		
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
		
		
//		JSplitPane splitLugar = new JSplitPane();
//		JOptionPane.showMessageDialog(null, msg);
		
		JSplitPane splitCancelarConfirmar = new JSplitPane();
		splitCancelarConfirmar.setBounds(1036, 677, 232, 30);
		splitCancelarConfirmar.setDividerSize(0);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener( a -> {
			m.cambiarPanel(new PanelHome(m));
		});
		splitCancelarConfirmar.setRightComponent(btnConfirmar);
		splitCancelarConfirmar.setLeftComponent(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(802, 19, 456, 561);
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 429, 757, 186);
		
		JTextArea txtReglamento = new JTextArea();
		txtReglamento.setMaximumSize(new Dimension(100, 100));
		scrollPane_1.setViewportView(txtReglamento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 206, 757, 14);
		separator.setBackground(Color.BLACK);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 362, 757, 14);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(802, 585, 232, 30);
		splitPane.setDividerSize(0);
		
		btnModificarLugar = new JButton("Modificar Lugar");
		btnModificarLugar.setEnabled(false);
		splitPane.setLeftComponent(btnModificarLugar);
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		splitPane.setRightComponent(btnAgregarLugar);
		
		JLabel lblCantidadTantos = new JLabel("Tantos por ausencia");
		lblCantidadTantos.setBounds(276, 311, 190, 26);
		lblCantidadTantos.setToolTipText("");
		lblCantidadTantos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 1256, 613);
		panel.setBackground(new Color(153, 204, 255));
		setLayout(null);
		add(lblCantidadSets);
		add(txtPuntosPresentarse);
		add(lblPuntosPartidoGanado);
		add(lblNombre);
		add(scrollPane);
		add(boxModalidad);
		add(lblModalidad);
		add(separator);
		add(rdbtnEmpate);
		add(lblReglamento);
		add(lblPuntosPresentarse);
		add(rdbtnSets);
		add(txtCantidadSets);
		add(splitPane);
		add(scrollPane_1);
		add(separator_1);
		add(txtTantosAusencia);
		add(rdbtnPuntuacion);
		add(rdbtnPuntuacionFinal);
		add(lblDeporte);
		add(lblCantidadTantos);
		add(txtPuntosPartidoGanado);
		add(txtPuntosEmpate);
		add(lblFormaPuntuacion);
		add(lblPuntosEmpate);
		add(txtNombre);
		add(boxDeporte);
		add(panel);
		add(splitCancelarConfirmar);
		
		btnAgregarLugar.addActionListener( a -> {
			DialogAltaLugar dialogAltaLugar = new DialogAltaLugar(this);
		});
		
		
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
			id_deporte = ((Item)this.boxDeporte.getSelectedItem()).getId();
			
			//Asigna valores de DTO
			//-----------------------------------------------------------------------------------------------------------------------------------------------------------
			compDTO = new CompetenciaDTO(this.nombreCompetencia,this.modalidadCompetencia, this.reglamentoCompetencia,
					this.cantSets, this.puntuacion, this.tantosXAusencia, this.empate,this.puntosPresentarse,
					this.puntosEmpate,this.puntosPartidoGanado, this.id_deporte, this.tableModel.getData(), this.id_usuario);

//			try {
//				gestorCompetencia.crearCompetencia(compDTO);
////				DialogExito dialogExito = new DialogExito(frame,"La competencia se guardo con EXITO");
//				JOptionPane.showMessageDialog(null, "La Competencia se guardo con exito","Dar de Alta Competencia",JOptionPane.INFORMATION_MESSAGE,emoji("icon/correcto1.png", 32,32));
//			}catch(Exception e) {
//				JOptionPane.showMessageDialog(null, "Ya existe una competencia con ese nombre. Reingrese uno distinto","Error",JOptionPane.ERROR_MESSAGE,emoji("icon/alerta1.png", 32,32));
//			}
			try {
				//TODO validacion de que los campos no estan completos, con mensaje especificando cada campo.
				//nombre competencia, deporte(?), lugares, modalidad(?), forma puntuacion(?)
				//liga: puntos ganar, empate(?), puntos empate(*), puntos presentarse
				//sets: cant max de sets, puntuacion: tantos por ausencia
				//confirmar si esta bien, los que tienen signos de pregunta no se si tienen un default 
				String CamposVacios="";
				if(compDTO.getNombre().isEmpty()) {
					CamposVacios=CamposVacios+"La competencia debe tener un nombre \n";
				}
				if(compDTO.getLugares().isEmpty()) {
					CamposVacios=CamposVacios+"La competencia debe tener al menos un lugar de realización \n ";
				}
				if(compDTO.getModalidad()==tp.enums.Modalidad.LIGA) {
					if(compDTO.getEmpate()&&compDTO.getPuntosXEmpate()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por empate \n ";
					}
					if(compDTO.getPuntosXGanado()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por partido ganado \n ";
					}
					if(compDTO.getPuntosXPresentarse()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por partido perdido \n ";
					}
				}
				switch(compDTO.getPuntuacion()) {
				case SETS:
					if(compDTO.getCantSets()==null) {
						CamposVacios=CamposVacios+"Debe ingresar una cantidad válida de sets \n ";
					}
					break;
				default:
					if(compDTO.getTantosXAusencia()==null) {
						CamposVacios=CamposVacios+"Debe ingresar puntos por ausencia \n ";
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
				if(compDTO.getPuntosXPresentarse()>=compDTO.getPuntosXGanado()) {
					throw new Exception("Los puntos por presentarse son mayores a los puntos por ganar.");
				}
				gestorCompetencia.crearCompetencia(compDTO);

				JOptionPane.showMessageDialog(null, "La Competencia se guardo con exito","Dar de Alta Competencia",JOptionPane.INFORMATION_MESSAGE,emoji("icon/correcto1.png", 32,32));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,emoji("icon/alerta1.png", 32,32));
			}
				
		});
		
	}
	
	public String reparse(String str) {
		String aux="";
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) aux+=str.charAt(i);
		}
		return aux;
	} 

	public String getDeporteCompetencia() {
		return this.boxDeporte.getSelectedItem().toString();
	}

	public void setDeporteCompetencia(String deporteCompetencia) {
		this.deporteCompetencia = deporteCompetencia;
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
	
	public void addItemTM(ItemLugarDTO item) { // este metodo agrega el item para la tabla 
		this.tableModel.addItemTM(item);
		this.tableLugares.updateUI();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	static public ImageIcon emoji(String fileName, int width, int height) {
		Image imagen = new ImageIcon(fileName).getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
		return new ImageIcon(imagen);
	}
}
