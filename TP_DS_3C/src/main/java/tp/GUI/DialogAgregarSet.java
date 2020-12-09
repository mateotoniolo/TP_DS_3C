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
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Dimension;

public class DialogAgregarSet extends JDialog {
	
	public final JPanel contentPanel = new JPanel();
	private JSplitPane splitPane;
	private JTextField textField_1;
	private JTextField textField;
	private JButton btnAgregar;
	private JButton btnCancelar;
	
	private ArrayList<Component> tabOrder = new ArrayList<Component>();
	
	public DialogAgregarSet(JFrame m) {
		super();
		setTitle("AGREGAR SET");
		inizializate(m);
	}
	public void inizializate(JFrame m) {
		
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 102, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(m);
		
		ordenDeTabulacion();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblEquipo1 = new JLabel("<Equipo 1>");
		lblEquipo1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		JLabel lblEquipo2 = new JLabel("<Equipo 2>");
		lblEquipo2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(40, 30));
		textField_1.setColumns(10);
		textField_1.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					textField_1.setText(reparse(textField_1.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					textField_1.setText(textField_1.getText());
				}
				if(code==KeyEvent.VK_ENTER) { //pasa al siguiente
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			} 
		});
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(40, 30));
		textField.setColumns(10);
		textField.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					textField_1.setText(reparse(textField_1.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					textField_1.setText(textField_1.getText());
				}
				if(code==KeyEvent.VK_ENTER) { //pasa al siguiente
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			} 
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEquipo1)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(lblEquipo2)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipo1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEquipo2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 102, 102));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					splitPane = new JSplitPane();
					splitPane.setDividerSize(0);
					{
						btnCancelar = new JButton("Cancelar");
						splitPane.setLeftComponent(btnCancelar);
					}
					{
						btnAgregar = new JButton("Agregar");
						btnAgregar.setBackground(new Color(51, 102, 255));
						splitPane.setRightComponent(btnAgregar);
						btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() { //Agregar con ENTER
							@Override
							public void keyReleased(KeyEvent e) {
								int code=e.getKeyCode();
								if(code==KeyEvent.VK_ENTER) {
									btnAgregar.addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent e) {
										}
									});
									btnAgregar.doClick();
								}
							}
						});
					}
				}
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap(236, Short.MAX_VALUE)
						.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(4)
						.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
			
		}
	}
	
	
	public String reparse(String str) {
		String aux="";
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) aux+=str.charAt(i);
		}
		return aux;
	} 
	
	private void ordenDeTabulacion() {		
		setFocusCycleRoot(true);
		textField.setFocusCycleRoot(true);
		textField_1.setFocusCycleRoot(true);
		btnAgregar.setFocusCycleRoot(true);
		
		tabOrder.add(textField);
		tabOrder.add(textField_1);
		tabOrder.add(btnAgregar);
		tabOrder.add(btnCancelar);

		setFocusTraversalPolicy(new PanelsFocusTraversalPolicy(tabOrder, textField));
		
	}
	
}
