package tp.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tp.DAO.DeporteDAO;
import tp.DAO.LugarDAO;
import tp.DTOs.ItemLugarDTO;
import tp.Gestores.GestorUsuario;
import tp.app.App;
import tp.clases.ItemLugar;
import tp.clases.Lugar;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

public class DialogAltaLugar extends JDialog {

	public final JPanel contentPanel = new JPanel();
	private JTextField txtDisponibilidad;
	JComboBox<String> boxLugar = new JComboBox<String>();
	List<ItemLugarDTO> lugares = new ArrayList<ItemLugarDTO>();
	
	private Integer disponibilidad = null;
	
	public class iniciar implements Runnable {
		PanelAltaCompetencia  panel= null;
		public iniciar(PanelAltaCompetencia p) {
			panel = p;
		}
		@Override
		public void run() {
				
			initialize(panel);			
		}
		
	}


	public DialogAltaLugar(PanelAltaCompetencia p) {
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
			new Thread (new iniciar(p), "inicializar").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void initialize(PanelAltaCompetencia p) {
		setTitle("Agregar Lugar");
		getContentPane().setBackground(new Color(153, 204, 255));
		setBounds(550, 350, 450, 162);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 123);
		contentPanel.setBackground(new Color(153, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		
		
		
		JLabel lblLugar = new JLabel("Disponibilidad *");
		lblLugar.setBounds(233, 16, 93, 17);
		contentPanel.add(lblLugar);
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		boxLugar.setBounds(6, 35, 215, 26);
		for (String lugar: GestorUsuario.getLugaresDisponibles(p.getId_usuario(),p.getId_deporte())){
			boxLugar.addItem(lugar);
		}
		contentPanel.add(boxLugar);
		
		
		JLabel lblDisponibilidad = new JLabel("Lugar *");
		lblDisponibilidad.setBounds(6, 16, 47, 17);
		contentPanel.add(lblDisponibilidad);
		lblDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 14));	
		
		txtDisponibilidad = new JTextField();
		txtDisponibilidad.setBounds(233, 34, 195, 28);
		contentPanel.add(txtDisponibilidad);
		
		//ignora el ingreso de caracteres no numericos
		txtDisponibilidad.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					txtDisponibilidad.setText(reparse(txtDisponibilidad.getText()));
				}
				
				int code=e.getKeyCode();
				if(code==KeyEvent.VK_BACK_SPACE) {
					txtDisponibilidad.setText(txtDisponibilidad.getText());
				}
			}
		});
						
				JSplitPane splitCancelarConfirmar = new JSplitPane();
				splitCancelarConfirmar.setBounds(248, 87, 180, 30);
				contentPanel.add(splitCancelarConfirmar);
				splitCancelarConfirmar.setDividerSize(0);
				
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.setBackground(new Color(51, 102, 255));
				btnConfirmar.addActionListener(a -> {
					try{
						try{	
							disponibilidad = Integer.parseInt(txtDisponibilidad.getText());
						}catch(Exception e) {
							throw new Exception("La disponibilidad debe ser una cantidad entera.");
						}
						if(disponibilidad == 0) {
							throw new Exception("La disponibilidad debe ser una cantidad entera mayor a 0(cero).");
						}else {
							Lugar place = GestorUsuario.getLugarByNombre(this.boxLugar.getSelectedItem().toString());
							ItemLugarDTO item = new ItemLugarDTO(place.getId(),place.getNombre(), disponibilidad);
						try{
							p.addItemTM(item);
							this.dispose();
						} catch(Exception e) {
							throw new Exception(e.getMessage());
						}
						//Crea el item con los datos ingresados
						}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
					}
				});
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener( a -> {


					this.dispose();

				});
				splitCancelarConfirmar.setRightComponent(btnConfirmar);
				splitCancelarConfirmar.setLeftComponent(btnCancelar);
				
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 0, 0, 0);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
			
			//TAB ORDEN
			List<Component> order = new ArrayList<Component>();
			
			setFocusCycleRoot(true);
			boxLugar.setFocusCycleRoot(true);
		    txtDisponibilidad.setFocusCycleRoot(true);
		    btnCancelar.setFocusCycleRoot(true);
		    btnConfirmar.setFocusCycleRoot(true);
		    
		    order.add(boxLugar);
		    order.add(txtDisponibilidad);
		    order.add(btnCancelar);
		    order.add(btnConfirmar);
		    
	        setFocusTraversalPolicy(new PanelsFocusTraversalPolicy(order, boxLugar));
				
	}
	
	
	public String reparse(String str) {
		String aux="";
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) aux+=str.charAt(i);
		}
		return aux;
	} 
	
}
