package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class DialogAlerta extends JDialog {
	
	public final JPanel contentPanel = new JPanel();
	
	
	public DialogAlerta(JFrame m, String msg) {
		super();
		inizialize(m, msg);
	}
	
	public void inizialize(JFrame m, String msg) {
		

		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("");
		setIconImage(null);
		contentPanel.setLayout(null);
		setLocationRelativeTo(m);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 30, 299, 103);
		contentPanel.add(scrollPane);
		
		JTextArea txtMsg = new JTextArea();
		txtMsg.setEditable(false);
		txtMsg.setLineWrap(true);
		txtMsg.setText(msg);
		txtMsg.setMaximumSize(new Dimension(13, 28));
		scrollPane.setViewportView(txtMsg);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
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
