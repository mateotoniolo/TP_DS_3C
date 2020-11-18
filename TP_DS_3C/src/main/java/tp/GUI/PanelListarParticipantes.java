package tp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import tp.clases.Competencia;

public class PanelListarParticipantes extends JPanel {
	private JTable tablaParticipantes;

	/**
	 * Create the panel.
	 */

	public PanelListarParticipantes(MainApplication m, Competencia competencia) {
		initialize(m, competencia);
	}

	private void initialize(MainApplication m, Competencia competencia ) {
		
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
		m.setTitle("PARTICIPANTES");
		setBounds(100, 50, 1280, 720);
		
		JPanel panelNombreCompetencia = new JPanel();
		panelNombreCompetencia.setBackground(new Color(153, 204, 255));
		
		JButton btnNuevoParticipante = new JButton("Nuevo");
		btnNuevoParticipante.setBackground(new Color(51, 102, 255));
		
		btnNuevoParticipante.addActionListener( a -> {
			if(competencia.getEstado() != "CREADA" && competencia.getEstado()!="PLANIFICADA") {
				JDialog dialogAlerta = new DialogAlerta("No es posible agregar participantes a esta Competencia");
			} else {
				JDialog dialogAltaParticipantes = new DialogAltaParticipante(competencia);
				dialogAltaParticipantes.setVisible(true);
			}
		});
		
		JScrollPane scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneTabla.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panelNombreEncuentro = new JPanel();
		panelNombreEncuentro.setBackground(Color.BLACK);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelNombreEncuentro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
						.addComponent(panelNombreCompetencia, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
						.addComponent(btnNuevoParticipante, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneTabla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelNombreCompetencia, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNombreEncuentro, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneTabla, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNuevoParticipante, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tablaParticipantes = new JTable();
		tablaParticipantes.setSelectionBackground(new Color(51, 102, 255));
		tablaParticipantes.setShowHorizontalLines(false);
		tablaParticipantes.setFont(new Font("Constantia", Font.BOLD, 20));
		tablaParticipantes.setRowHeight(40);
		tablaParticipantes.setModel(new DefaultTableModel(
			new Object[][] {
				{"Equipo 1", "eq01@gmail.com"},
				{"Equipo 2", "eq02@gmail.com"},
				{"Equipo 3", "eq03@gmail.com"},
				{"Equipo 4", "eq04@gmail.com"},
				{"Equipo 5", "eq05@gmail.com"},
				{"Equipo 6", "eq06@gmail.com"},
				{"Equipo 7", "eq07@gmail.com"},
				{"Equipo 8", "eq08@gmail.com"},
				{"Equipo 9", "eq09@gmail.com"},
				{"Equipo 10", "eq10@gmail.com"},
				{"Equipo 11", "eq11@gmail.com"},
				{"Equipo 12", "eq12@gmail.com"},
				{"Equipo 13", "eq01@gmail.com"},
			},
			new String[] {
				"Nombre", "Correo Electronico"
			}
		));
		scrollPaneTabla.setViewportView(tablaParticipantes);
		panelNombreCompetencia.setLayout(new BorderLayout(0, 0));
		
		
//		TODO PARA HACER CLICK DERECHO Y ABRIR OPCIONES MODIFICAR-ELIMINAR 
		tablaParticipantes.addMouseListener(new MouseAdapter() {
		       @Override
		       public void mouseReleased(MouseEvent e) {
		           int r = tablaParticipantes.rowAtPoint(e.getPoint());
		           if (r >= 0 && r < tablaParticipantes.getRowCount()) {
		        	   tablaParticipantes.setRowSelectionInterval(r, r);
		           } else {
		        	   tablaParticipantes.clearSelection();
		           }

		           int rowindex = tablaParticipantes.getSelectedRow();
		           if (rowindex < 0)
		               return;
		           if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		               JPopupMenu popup = new JPopupMenu();
		               popup.show(e.getComponent(), e.getX(), e.getY());
		           }
		       }
		});
		
		JLabel lblNombreCompetencia = new JLabel("Competencia");
		if(competencia.getNombre()!=null) lblNombreCompetencia.setText(competencia.getNombre()); 
		lblNombreCompetencia.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelNombreCompetencia.add(lblNombreCompetencia, BorderLayout.WEST);
		setLayout(groupLayout);
		
	}
}
