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
import javax.swing.JTextField;

public class DialogModificarLugar extends JDialog {

	public final JPanel contentPanel = new JPanel();
	private JTextField textField;
	JComboBox<String> boxLugar = new JComboBox<String>();
	List<ItemLugarDTO> lugares = new ArrayList<ItemLugarDTO>();
	ItemLugarDTO itemDTO ;
	
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


	public DialogModificarLugar(PanelAltaCompetencia p, ItemLugarDTO itemDTO) {
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
			this.itemDTO = itemDTO;
			new Thread (new iniciar(p), "inicializar").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void initialize(PanelAltaCompetencia p) {
		setTitle("Modificar Lugar");
		getContentPane().setBackground(new Color(153, 204, 255));
		setBounds(550, 350, 450, 162);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 123);
		contentPanel.setBackground(new Color(153, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(233, 34, 195, 28);
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		contentPanel.add(textField);
		
		textField.addKeyListener(new java.awt.event.KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!c.isDigit(c)) {
					try{
						textField.setText(textField.getText().substring(0, textField.getText().length()-1));
					}catch(Exception ex) {};
				} 
			} 
		});
		
		
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
						
				JSplitPane splitCancelarConfirmar = new JSplitPane();
				splitCancelarConfirmar.setBounds(248, 87, 180, 30);
				contentPanel.add(splitCancelarConfirmar);
				splitCancelarConfirmar.setDividerSize(0);
				
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.setBackground(new Color(102, 102, 255));
				btnConfirmar.addActionListener(a -> {
					try{
						try{					
							disponibilidad = Integer.parseInt(textField.getText());
						}catch(Exception e) {
							throw new Exception("La disponibilidad debe ser una cantidad entera.");
						}
						if(disponibilidad == 0) {
							throw new Exception("La disponibilidad debe ser una cantidad entera mayor a 0(cero).");
						}else {
							Lugar place = GestorUsuario.getLugarByNombre(this.boxLugar.getSelectedItem().toString());
							ItemLugarDTO item = new ItemLugarDTO(place.getId(),place.getNombre(), disponibilidad);
					
						try {
							p.tableModel.remove(itemDTO);
							p.addItemTM(item);
							this.dispose();
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE,App.emoji("icon/alerta1.png", 32,32));
						}
					//Modifica el item con los datos ingresados
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
		
			
			
	}
	
	
		
	
}
