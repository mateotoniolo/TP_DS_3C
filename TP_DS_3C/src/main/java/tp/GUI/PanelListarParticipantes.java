package tp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import tp.DTOs.ParticipanteDTO;
import tp.Gestores.GestorCompetencia;
import tp.app.App;
import tp.clases.Competencia;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;

public class PanelListarParticipantes extends JPanel {
	private JTable tablaParticipantes;
	ListarParticipantesTM tableModel ;
	Integer id_competencia;
	JPanel llamante;
	boolean PanelAlta = false;
	/**
	 * Create the panel.
	 */

	public PanelListarParticipantes(MainApplication m, JPanel llamante, Integer id_competencia) {
		this.id_competencia = id_competencia;
		this.llamante = llamante;
		initialize(m,id_competencia);
	}





//	public PanelListarParticipantes(MainApplication m, PanelAltaCompetencia llamante,
//			Integer id_competencia) {
//		this.id_competencia = id_competencia;
//		this.llamante = llamante;
//		this.PanelAlta = true;
//		initialize(m,id_competencia);
//	}





	private void initialize(MainApplication m,Integer id_competencia ) {
		
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
		Competencia competencia = GestorCompetencia.getCompetenciaByID(id_competencia);
		
		setBackground(new Color(102, 102, 102));
		m.setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 50, 1366, 740);
		
		JPanel panelNombreCompetencia = new JPanel();
		panelNombreCompetencia.setBackground(new Color(153, 204, 255));
		
		JScrollPane scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneTabla.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panelNombreEncuentro = new JPanel();
		panelNombreEncuentro.setBackground(Color.BLACK);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelNombreEncuentro, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
						.addComponent(panelNombreCompetencia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
						.addComponent(scrollPaneTabla, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
						.addComponent(splitPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNombreCompetencia, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNombreEncuentro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneTabla, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		
		JButton btnNuevoParticipante = new JButton("Agregar");
		splitPane.setRightComponent(btnNuevoParticipante);
		btnNuevoParticipante.setBackground(new Color(51, 102, 255));
		
		JButton btnAtras = new JButton("Atrás");
		splitPane.setLeftComponent(btnAtras);
		
		btnAtras.addActionListener( a -> {
			if(!PanelAlta) {
				((PanelListarCompetenciasDeportivas)llamante).actualizar();
				m.cambiarPanel(llamante);
			}else {
				m.cambiarPanel(new PanelAltaCompetencia(m, ((PanelAltaCompetencia)llamante).previo));
			}
			
		});
		
		btnNuevoParticipante.addActionListener( a -> {
			try {
				int valor = JOptionPane.YES_NO_OPTION;
				JOptionPane.showMessageDialog(null, "Seguro desea agregar un nuevo participante?","Confirmación",valor,App.emoji("icon/pregunta1.png", 32,32));				
				if(valor == JOptionPane.YES_OPTION) {
				GestorCompetencia.validar(id_competencia);
				JDialog dialogAltaParticipantes = new DialogAltaParticipante(m,this, id_competencia);
				dialogAltaParticipantes.setVisible(true);}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
			}
			
			
			
		});
		tableModel  = new ListarParticipantesTM();	
		for(ParticipanteDTO p : GestorCompetencia.mostrarParticipantes(id_competencia)) {
			tableModel.addItemTM(p);
		}
		tablaParticipantes = new JTable();
		tablaParticipantes.setModel(tableModel);
		tablaParticipantes.setSelectionBackground(new Color(51, 102, 255));
		tablaParticipantes.setShowHorizontalLines(false);
		tablaParticipantes.setFont(new Font("Constantia", Font.BOLD, 20));
		tablaParticipantes.setRowHeight(40);
		
		scrollPaneTabla.setViewportView(tablaParticipantes);
		tablaParticipantes.setAutoCreateRowSorter(true);
		panelNombreCompetencia.setLayout(new BorderLayout(0, 0));
		
		
		
		JLabel lblNombreCompetencia = new JLabel("Competencia");
		lblNombreCompetencia.setText(competencia.getNombre()); 
		lblNombreCompetencia.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelNombreCompetencia.add(lblNombreCompetencia, BorderLayout.WEST);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(PanelListarParticipantes.class.getResource("/img/home.png")));
		panelNombreCompetencia.add(btnHome, BorderLayout.EAST);
		setLayout(groupLayout);
		
		btnHome.addActionListener( a -> {
			m.cambiarPanel(new PanelHome(m));
		});
		
		
		
		//TAB ORDEN
		List<Component> order = new ArrayList<Component>();
				
		setFocusCycleRoot(true);
		btnAtras.setFocusCycleRoot(true);
		btnNuevoParticipante.setFocusCycleRoot(true);
		btnHome.setFocusCycleRoot(true);
			    
		order.add(btnAtras);
		order.add(btnNuevoParticipante);
		order.add(btnHome);
			    
		setFocusTraversalPolicy(new PanelsFocusTraversalPolicy(order, btnNuevoParticipante));
		
		
	}
	public void actualizarTabla() { // este metodo agrega el item para la tabla 
		tableModel.vaciarTabla();
		for(ParticipanteDTO p : GestorCompetencia.mostrarParticipantes(id_competencia)) {
			tableModel.addItemTM(p);
		}
		this.tablaParticipantes.updateUI();
	}
}
