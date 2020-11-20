package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class DialogExito extends JDialog {
	
	public final JPanel contentPanel = new JPanel();
	
	public DialogExito(JFrame m, String msg) {
		super();
		inizializate(m, msg);
	}
	public void inizializate(JFrame m, String msg) {
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("");
		setIconImage(null);
		setLocationRelativeTo(m);
		
		contentPanel.setLayout(null);
		{
			JLabel lblExito = new JLabel("\u00C9XITO");
			lblExito.setBounds(162, 11, 77, 25);
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
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(89, 30, 299, 103);
			contentPanel.add(scrollPane);
			{
				JTextArea txtMsg = new JTextArea();
				txtMsg.setText(msg);
				txtMsg.setMaximumSize(new Dimension(13, 28));
				txtMsg.setLineWrap(true);
				txtMsg.setEditable(false);
				scrollPane.setViewportView(txtMsg);
			}
		}
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
