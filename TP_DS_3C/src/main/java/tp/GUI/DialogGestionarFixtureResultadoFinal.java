package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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

public class DialogGestionarFixtureResultadoFinal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public DialogGestionarFixtureResultadoFinal(JFrame m) {
		setTitle("MODIFICAR RESULTADO");
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 102, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(m);
		
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
						.addComponent(panelCeleste, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
						.addComponent(panelNombreEncuentro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(panelBlancoL, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelBlancoR, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
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
						.addComponent(panelBlancoL, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBlancoR, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
		);
		
		JLabel lblAsistencia = new JLabel("ASISTENCIA");
		lblAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox checkEquipo1 = new JCheckBox("<EQUIPO 1>");
		checkEquipo1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JCheckBox checkEquipo2 = new JCheckBox("<EQUIPO 2>");
		checkEquipo2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GroupLayout gl_panelBlancoR = new GroupLayout(panelBlancoR);
		gl_panelBlancoR.setHorizontalGroup(
			gl_panelBlancoR.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBlancoR.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(lblAsistencia, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
				.addGroup(gl_panelBlancoR.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_panelBlancoR.createParallelGroup(Alignment.LEADING)
						.addComponent(checkEquipo2)
						.addComponent(checkEquipo1))
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_panelBlancoR.setVerticalGroup(
			gl_panelBlancoR.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlancoR.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAsistencia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(checkEquipo1)
					.addGap(29)
					.addComponent(checkEquipo2)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panelBlancoR.setLayout(gl_panelBlancoR);
		
		JLabel lblResultado = new JLabel("RESULTADO");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JRadioButton rdbtnGanador1 = new JRadioButton("Ganador: <EQUIPO1>");
		rdbtnGanador1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JRadioButton rdbtnGanador2 = new JRadioButton("Ganador: <EQUIPO1>");
		rdbtnGanador2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GroupLayout gl_panelBlancoL = new GroupLayout(panelBlancoL);
		gl_panelBlancoL.setHorizontalGroup(
			gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlancoL.createSequentialGroup()
					.addGroup(gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBlancoL.createSequentialGroup()
							.addGap(135)
							.addComponent(lblResultado))
						.addGroup(gl_panelBlancoL.createSequentialGroup()
							.addGap(55)
							.addGroup(gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnGanador1)
								.addComponent(rdbtnGanador2)
								.addComponent(rdbtnEmpate))))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		gl_panelBlancoL.setVerticalGroup(
			gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlancoL.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblResultado)
					.addGap(31)
					.addComponent(rdbtnGanador1)
					.addGap(30)
					.addComponent(rdbtnGanador2)
					.addGap(28)
					.addComponent(rdbtnEmpate)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panelBlancoL.setLayout(gl_panelBlancoL);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNegro = new JLabel("<NOMBRE DE ENCUENTRO>");
		lblNegro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNegro.setForeground(new Color(255, 255, 255));
		panelNombreEncuentro.add(lblNegro, BorderLayout.CENTER);
		
		JLabel lblResultadoFinal = new JLabel("RESULTADO FINAL     ");
		lblResultadoFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResultadoFinal.setForeground(new Color(255, 255, 255));
		panelNombreEncuentro.add(lblResultadoFinal, BorderLayout.EAST);
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
