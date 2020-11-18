package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class DialogGestionarFixtureSets extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionarFixtureSets dialog = new DialogGestionarFixtureSets();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionarFixtureSets() {
		setTitle("MODIFICAR RESULTADO");
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 102, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panelCeleste = new JPanel();
		panelCeleste.setBackground(new Color(153, 204, 255));
		JPanel panelNombreEncuentro = new JPanel();
		panelNombreEncuentro.setBackground(new Color(0, 0, 0));
		JPanel panelBlancoL = new JPanel();
		panelBlancoL.setBackground(new Color(255, 255, 255));
		
		JPanel panelBlancoR = new JPanel();
		panelBlancoR.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCeleste, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
						.addComponent(panelNombreEncuentro, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(panelBlancoL, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelBlancoR, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCeleste, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNombreEncuentro, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBlancoR, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBlancoL, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
		);
		
		JLabel lblAsistencia = new JLabel("ASISTENCIA");
		lblAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox checkEquipo1 = new JCheckBox("<EQUIPO 1>");
		checkEquipo1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JCheckBox checkEquipo2 = new JCheckBox("<EQUIPO 2>");
		checkEquipo2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GroupLayout gl_panelBlancoR = new GroupLayout(panelBlancoR);
		gl_panelBlancoR.setHorizontalGroup(
			gl_panelBlancoR.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBlancoR.createSequentialGroup()
					.addContainerGap(152, Short.MAX_VALUE)
					.addGroup(gl_panelBlancoR.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelBlancoR.createSequentialGroup()
							.addComponent(lblAsistencia, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(78))
						.addGroup(Alignment.TRAILING, gl_panelBlancoR.createSequentialGroup()
							.addGroup(gl_panelBlancoR.createParallelGroup(Alignment.LEADING)
								.addComponent(checkEquipo2)
								.addComponent(checkEquipo1))
							.addGap(136))))
		);
		gl_panelBlancoR.setVerticalGroup(
			gl_panelBlancoR.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlancoR.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAsistencia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(checkEquipo1)
					.addGap(29)
					.addComponent(checkEquipo2)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panelBlancoR.setLayout(gl_panelBlancoR);
		
		JLabel lblResultado = new JLabel("RESULTADO");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAgregarSet = new JButton("Agregar Set");
		GroupLayout gl_panelBlancoL = new GroupLayout(panelBlancoL);
		gl_panelBlancoL.setHorizontalGroup(
			gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlancoL.createSequentialGroup()
					.addGroup(gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBlancoL.createSequentialGroup()
							.addGap(180)
							.addComponent(lblResultado))
						.addGroup(gl_panelBlancoL.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panelBlancoL.createSequentialGroup()
							.addContainerGap(360, Short.MAX_VALUE)
							.addComponent(btnAgregarSet)))
					.addContainerGap())
		);
		gl_panelBlancoL.setVerticalGroup(
			gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlancoL.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblResultado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnAgregarSet)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setRowHeight(40);
		table.setSelectionBackground(new Color(51, 102, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Sets", "<Equipo 1>", "<Equipo 2>"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(0).setMinWidth(35);
		table.getColumnModel().getColumn(0).setMaxWidth(35);
		table.getColumnModel().getColumn(1).setMinWidth(35);
		table.getColumnModel().getColumn(2).setMinWidth(35);
		table.setFont(new Font("Constantia", Font.BOLD, 20));
		scrollPane.setViewportView(table);
		panelBlancoL.setLayout(gl_panelBlancoL);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNegro = new JLabel("<NOMBRE DE ENCUENTRO>");
		lblNegro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNegro.setForeground(new Color(255, 255, 255));
		panelNombreEncuentro.add(lblNegro, BorderLayout.CENTER);
		
		JLabel lblPuntuacion = new JLabel("PUNTUACI\u00D3N     ");
		lblPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPuntuacion.setForeground(new Color(255, 255, 255));
		panelNombreEncuentro.add(lblPuntuacion, BorderLayout.EAST);
		panelCeleste.setLayout(new BoxLayout(panelCeleste, BoxLayout.X_AXIS));
		
		JLabel lblNombreTorneo = new JLabel("<NOMBRE TORNEO>");
		lblNombreTorneo.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelCeleste.add(lblNombreTorneo);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 102, 102));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setBackground(new Color(51, 102, 255));
				btnGuardar.setActionCommand("Cancel");
				buttonPane.add(btnGuardar);
			}
		}
	}
}
