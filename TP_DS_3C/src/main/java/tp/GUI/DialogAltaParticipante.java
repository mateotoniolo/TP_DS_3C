package tp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import tp.DTOs.CompetenciaDTO;
import tp.DTOs.ParticipanteDTO;
import tp.Gestores.GestorCompetencia;
import tp.app.App;
import javax.swing.JTextField;
import java.awt.Dimension;

public class DialogAltaParticipante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCorreoElectronico;
	private JTextField txtNombre;
	private JButton btnAgregar ;
	private JButton btnCancelar;
	private Integer id_competencia;
	
	private String nombre;
	private String correoElectronico;
	
	private ArrayList<Component> tabOrder = new ArrayList<Component>();

	public DialogAltaParticipante(JFrame m,PanelListarParticipantes listaParticipantes, CompetenciaDTO competencia) {
		setTitle("Agregar Participante");
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 102, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(m);
		
		
		
		this.id_competencia = competencia.getId_competencia();
		JPanel panelCeleste = new JPanel();
		panelCeleste.setBackground(new Color(153, 204, 255));
		JPanel panelNombreEncuentro = new JPanel();
		panelNombreEncuentro.setBackground(new Color(0, 0, 0));
		JPanel panelBlanco = new JPanel();
		panelBlanco.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCeleste, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(panelNombreEncuentro, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
						.addComponent(panelBlanco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
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
					.addComponent(panelBlanco, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico *");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setPreferredSize(new Dimension(7, 30));
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() { //avanza al siguiente
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}

			}
		});
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(7, 30));
		txtNombre.setColumns(10);	
		txtNombre.addKeyListener(new java.awt.event.KeyAdapter() { //avanza al siguiente
			@Override
			public void keyReleased(KeyEvent e) {
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_ENTER) {
					KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}

			}
		});
		
		GroupLayout gl_panelBlanco = new GroupLayout(panelBlanco);
		gl_panelBlanco.setHorizontalGroup(
			gl_panelBlanco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlanco.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_panelBlanco.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCorreoElectronico, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelBlanco.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCorreoElectronico, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelBlanco.setVerticalGroup(
			gl_panelBlanco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBlanco.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_panelBlanco.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panelBlanco.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreoElectronico)
						.addComponent(txtCorreoElectronico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panelBlanco.setLayout(gl_panelBlanco);
		panelNombreEncuentro.setLayout(new BorderLayout(0, 0));
		panelCeleste.setLayout(new BoxLayout(panelCeleste, BoxLayout.X_AXIS));
		
		JLabel lblNombreCompetencia = new JLabel("NUEVO PARTICIPANTE");
		lblNombreCompetencia.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelCeleste.add(lblNombreCompetencia);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 102, 102));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
				
				btnCancelar.addActionListener( a -> {
					dispose();
				});
			}
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.setBackground(new Color(51, 102, 255));
				btnAgregar.setActionCommand("Cancel");
				buttonPane.add(btnAgregar);
				btnAgregar.setEnabled(true);
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
				btnAgregar.addActionListener( a -> {
						 correoElectronico = txtCorreoElectronico.getText().toString();
						 nombre = txtNombre.getText().toString();
						try {
							if(GestorCompetencia.crearParticipante(competencia, new ParticipanteDTO(nombre,correoElectronico))) {
							JOptionPane.showMessageDialog(null, "Nuevo participante agregado con éxito","Agregar Participante",JOptionPane.INFORMATION_MESSAGE,App.emoji("icon/correcto1.png", 32,32));
							listaParticipantes.actualizarTabla();
							dispose();
							}						
						}catch(Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
						}
						ordenDeTabulacion();						
				});
			}
		}
	}
	
	

	private void ordenDeTabulacion() {		
		setFocusCycleRoot(true);
		txtNombre.setFocusCycleRoot(true);
		txtCorreoElectronico.setFocusCycleRoot(true);
		btnAgregar.setFocusCycleRoot(true);
		
		tabOrder.add(txtNombre);
		tabOrder.add(txtCorreoElectronico);
		tabOrder.add(btnAgregar);
		tabOrder.add(btnCancelar);

		setFocusTraversalPolicy(new PanelsFocusTraversalPolicy(tabOrder, txtNombre));
		
	}
}
