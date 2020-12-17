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
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.GridLayout;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.CompetenciaPartidosDTO;
import tp.DTOs.FixtureDTO;
import tp.DTOs.PartidoDTO;
import tp.Gestores.GestorCompetencia;
import tp.Gestores.GestorFixture;
import tp.app.App;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class DialogVerCompetencia extends JDialog {
	private JTable table ;
	private JPanel panelBotonesR;
	private JLabel lblNombreCompetencia; 
	private VerCompetenciaTM tableModel = new VerCompetenciaTM();
	private JPanel llamante;

	private GestorCompetencia gestorCompetencia = new GestorCompetencia();
		
	private CompetenciaDTO compDTO;
	private CompetenciaPartidosDTO compPartDTO;
	private boolean isAltaCompetencia = false;
	/**
	 * Create the panel.
	 */
	

	public DialogVerCompetencia(MainApplication m,PanelListarCompetenciasDeportivas p, Integer id_competencia) {
		llamante = p;
		initialize(m, id_competencia);
	}
	
	public DialogVerCompetencia(MainApplication m,PanelAltaCompetencia p, Integer id_competencia) {
		llamante = p;
		initialize(m, id_competencia);
		isAltaCompetencia = true;
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
		
		compDTO = GestorCompetencia.getCompetenciaDTObyID(id_competencia);
		compPartDTO = gestorCompetencia.mostrarCompetencia(compDTO);
		
		setBackground(new Color(102, 102, 102));
		setBounds(100, 50, 1000, 657);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelDown = new JPanel();
		panelDown.setPreferredSize(new Dimension(10, 210));
		panelDown.setBackground(new Color(102, 102, 102));
		getContentPane().add(panelDown, BorderLayout.SOUTH);
		
		JPanel panelBotonesL = new JPanel();
		panelBotonesL.setBackground(new Color(102, 102, 102));
		
		panelBotonesR = new JPanel();
		panelBotonesR.setBackground(new Color(102, 102, 102));
		panelBotonesR.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVerTablaDePosiciones = new JButton("Ver Tabla de Posiciones");
		btnVerTablaDePosiciones.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesR.add(btnVerTablaDePosiciones);
		
		JButton btnFixture = new JButton("Ver Fixture");
		btnFixture.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesR.add(btnFixture);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnEliminar.setBackground(new Color(204, 0, 0));
		panelBotonesR.add(btnEliminar);
		GroupLayout gl_panelDown = new GroupLayout(panelDown);
		gl_panelDown.setHorizontalGroup(
			gl_panelDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDown.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelBotonesL, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBotonesR, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelDown.setVerticalGroup(
			gl_panelDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDown.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDown.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotonesR, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBotonesL, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		panelBotonesL.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVerParticipantes = new JButton("Ver Participantes");
		btnVerParticipantes.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesL.add(btnVerParticipantes);
		
		btnVerParticipantes.addActionListener( a -> {
			dispose();
			
			if(isAltaCompetencia) {
				m.cambiarPanel(new PanelListarParticipantes(m, (PanelAltaCompetencia)llamante, new CompetenciaDTO(id_competencia)));
			}
			else {
				m.cambiarPanel(new PanelListarParticipantes(m, (PanelListarCompetenciasDeportivas)llamante, new CompetenciaDTO(id_competencia), true));
			}
			
		});
		
		JButton btnGenerarFixture = new JButton("Generar Fixture");
		btnGenerarFixture.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelBotonesL.add(btnGenerarFixture);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnModificar.setBackground(new Color(51, 102, 255));
		btnModificar.setForeground(new Color(0, 0, 0));
		
		JLabel lblEstado = new JLabel("Estado: ...");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		if(compPartDTO.getEstado() != null) {
			lblEstado.setText("Estado: " + compPartDTO.getEstado().toString());
		}
		// Si el fixture no esta creado, se bloquea el boton
		if(!compPartDTO.isCreated()) {
			btnModificar.setEnabled(false);
		}
		
		
		// Logica de botones
		btnVerTablaDePosiciones.addActionListener( a -> {
			
		});
		
		btnFixture.addActionListener( a -> {
			
		});
		
		btnEliminar.addActionListener( a -> {
			
		});
		
		btnVerParticipantes.addActionListener( a -> {
			dispose();
			if(isAltaCompetencia) {
				m.cambiarPanel(new PanelListarParticipantes(m,(PanelAltaCompetencia)llamante,new CompetenciaDTO(id_competencia)));
			}
			else {
				m.cambiarPanel(new PanelListarParticipantes(m,(PanelListarCompetenciasDeportivas)llamante,new CompetenciaDTO(id_competencia)));
			}
		});
		
		btnGenerarFixture.addActionListener( a -> {
			if(compDTO.getModalidad() != Modalidad.LIGA) {
				JOptionPane.showMessageDialog(null, "Solo se crea el fixture de competencias con modalidad Liga.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}
			else {
				try {
					int result = JOptionPane.showConfirmDialog(null,"Seguro desea generar un nuevo fixture para esta competencia?", "Confirmación",
				            JOptionPane.OK_CANCEL_OPTION,
				            JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.OK_OPTION) {
						GestorCompetencia.generarFixture(compDTO);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
				}
				try {
				actualizarTabla(id_competencia);
				lblEstado.setText("Estado: " + EstadoCompetencia.PLANIFICADA.toString());
				if(!isAltaCompetencia) {
					((PanelListarCompetenciasDeportivas)llamante).actualizar();
				}
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Hubo un errror al actualizar la tabla. Intente nuevamente.","ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
				}
			}
		});
		
		btnModificar.addActionListener( a -> {
			
		});
		
		panelBotonesL.add(btnModificar);
		panelDown.setLayout(gl_panelDown);
		
		JPanel panelUp = new JPanel();
		panelUp.setBackground(new Color(102, 102, 102));
		getContentPane().add(panelUp, BorderLayout.NORTH);
		
		JPanel panelL = new JPanel();
		panelL.setBackground(new Color(255, 255, 255));
		
		JLabel lblPunto1 = new JLabel("");
		lblPunto1.setIcon(new ImageIcon(DialogVerCompetencia.class.getResource("/img/marca.png")));
		
		JLabel lblModalidad = new JLabel("Modalidad: ...");
		if(compPartDTO.getModalidad() != null) {
			lblModalidad.setText("Modalidad: " + compPartDTO.getModalidad());
		}
		
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDeporte = new JLabel("Deporte: ...");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		if(compPartDTO.getDeporte() != null) {
			lblDeporte.setText("Deporte: " + compPartDTO.getDeporte().getNombre());
		}
		
		JLabel lblPunto2 = new JLabel("");
		lblPunto2.setIcon(new ImageIcon(DialogVerCompetencia.class.getResource("/img/marca.png")));
		
		JLabel lblPunto3 = new JLabel("");
		lblPunto3.setIcon(new ImageIcon(DialogVerCompetencia.class.getResource("/img/marca.png")));
		
		
		GroupLayout gl_panelL = new GroupLayout(panelL);
		gl_panelL.setHorizontalGroup(
			gl_panelL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelL.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelL.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL.createSequentialGroup()
							.addComponent(lblPunto1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblModalidad, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelL.createSequentialGroup()
							.addComponent(lblPunto2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelL.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPunto3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panelL.setVerticalGroup(
			gl_panelL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelL.createSequentialGroup()
					.addGroup(gl_panelL.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPunto1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelL.createSequentialGroup()
							.addGap(29)
							.addComponent(lblModalidad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelL.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPunto2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelL.createSequentialGroup()
							.addGap(42)
							.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelL.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPunto3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelL.createSequentialGroup()
							.addGap(42)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(56))
		);
		panelL.setLayout(gl_panelL);
		
		
		JPanel panelR = new JPanel();
		panelR.setBackground(Color.WHITE);
		
		JPanel panelNombreCompetencia = new JPanel();
		panelNombreCompetencia.setBackground(new Color(153, 204, 255));
		
		JPanel panelNegro = new JPanel();
		panelNegro.setBackground(Color.BLACK);
		GroupLayout gl_panelUp = new GroupLayout(panelUp);
		gl_panelUp.setHorizontalGroup(
			gl_panelUp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUp.createParallelGroup(Alignment.LEADING)
						.addComponent(panelL, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelNombreCompetencia, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelNegro, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelR, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelUp.setVerticalGroup(
			gl_panelUp.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelUp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUp.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelUp.createSequentialGroup()
							.addComponent(panelNombreCompetencia, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelNegro, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelL, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
						.addComponent(panelR, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelNombreCompetencia.setLayout(new BorderLayout(0, 0));
		
		lblNombreCompetencia = new JLabel("COMPETENCIA");
		if(compPartDTO.getNombre()!=null) lblNombreCompetencia.setText(compPartDTO.getNombre());
		lblNombreCompetencia.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelNombreCompetencia.add(lblNombreCompetencia, BorderLayout.WEST);
		
		JLabel lblProximosEncuentros = new JLabel("Pr\u00F3ximos Encuentros");
		lblProximosEncuentros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		GroupLayout gl_panelR = new GroupLayout(panelR);
		gl_panelR.setHorizontalGroup(
			gl_panelR.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelR.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelR.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
						.addComponent(lblProximosEncuentros))
					.addContainerGap())
		);
		gl_panelR.setVerticalGroup(
			gl_panelR.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelR.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProximosEncuentros)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelR.setLayout(gl_panelR);
		panelUp.setLayout(gl_panelUp);
		
		//Carga la tabla de proximos partidos
		if(compDTO.getId_fixture() != null) {
			for(PartidoDTO p : GestorFixture.getProximosEncuentros(new FixtureDTO(compDTO.getId_fixture()))) {
				this.tableModel.addItemTM(p);
			}
		}
	}
	public void actualizarTabla(Integer id_competencia) {
		this.tableModel.removeAll();
		for(PartidoDTO p : GestorFixture.getProximosEncuentros(new FixtureDTO(GestorCompetencia.getCompetenciaByID(id_competencia).getFixture().getId_fixture()))) {
			this.tableModel.addItemTM(p);
		}
		this.table.updateUI();
	}
}
