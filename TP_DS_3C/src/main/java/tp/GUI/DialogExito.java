package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DialogExito extends JDialog {
	
	public final JPanel contentPanel = new JPanel();
	
	public DialogExito() {
		super();
		inizializate();
	}
	public void inizializate() {
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInformacion = new JLabel("La competencia fue creada correctamente.");
			lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblInformacion.setBounds(103, 30, 281, 103);
			contentPanel.add(lblInformacion);
		}
		{
			JLabel lblExito = new JLabel("\u00C9XITO");
			lblExito.setBounds(168, 11, 77, 25);
			lblExito.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblExito);
		}
		{
			JLabel imgExito = new JLabel("");
			imgExito.setBounds(5, 30, 72, 103);
			imgExito.setIcon(new ImageIcon(DialogExito.class.getResource("/img/correcto1.png")));
			contentPanel.add(imgExito);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setAlignmentY(Component.TOP_ALIGNMENT);
				btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				
				btnAceptar.addActionListener( a -> {
					dispose();
				});
			}
			
		}
	}

}
