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

public class DialogAlerta extends JDialog {
	
	public final JPanel contentPanel = new JPanel();
	
	
	public DialogAlerta() {
		super();
		inizialize();
	}
	
	public void inizialize() {
		

		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInformacion = new JLabel("No se pudo guardar la competencia.");
			lblInformacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblInformacion.setBounds(122, 30, 219, 103);
			contentPanel.add(lblInformacion);
		}
		{
			JLabel lblError = new JLabel("ERROR");
			lblError.setBounds(180, 11, 77, 25);
			lblError.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblError);
		}
		{
			JLabel imgAlerta = new JLabel("");
			imgAlerta.setBounds(5, 30, 72, 103);
			imgAlerta.setIcon(new ImageIcon(DialogAlerta.class.getResource("/img/alerta1.png")));
			contentPanel.add(imgAlerta);
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
