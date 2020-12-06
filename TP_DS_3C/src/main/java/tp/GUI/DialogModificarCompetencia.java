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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextField;

public class DialogModificarCompetencia extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public DialogModificarCompetencia(JFrame m) {
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCeleste, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(panelNombreEncuentro, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(panelBlancoL, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
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
					.addComponent(panelBlancoL, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panelBlancoL = new GroupLayout(panelBlancoL);
		gl_panelBlancoL.setHorizontalGroup(
			gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
				.addGap(0, 448, Short.MAX_VALUE)
		);
		gl_panelBlancoL.setVerticalGroup(
			gl_panelBlancoL.createParallelGroup(Alignment.LEADING)
				.addGap(0, 225, Short.MAX_VALUE)
		);
		panelBlancoL.setLayout(gl_panelBlancoL);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		panelCeleste.setLayout(new BoxLayout(panelCeleste, BoxLayout.X_AXIS));
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
