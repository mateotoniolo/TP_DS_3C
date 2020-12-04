package tp.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.DTOs.ItemLugarDTO;
import tp.DTOs.ParticipanteDTO;
import tp.clases.ItemLugar;
import tp.clases.Lugar;




public class ListarParticipantesTM extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ParticipanteDTO> data = new ArrayList<ParticipanteDTO>();
	private String[] columnNames = {"Nombre","E-mail"};
	
	public ListarParticipantesTM() {
		
	}
	
	public void addItemTM(ParticipanteDTO item) {
		this.data.add(item);
	}
	
	
	@Override
	public int getRowCount() {
		return data.size();
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		ParticipanteDTO temp = data.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return temp.getNombre();
		case 1:
			return temp.getEmail();
		}
		return null;
	}
	
	@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void vaciarTabla() {
		this.data = null;
		this.data = new ArrayList<ParticipanteDTO>();
	}

	public List<ParticipanteDTO> getData() {
		return data;
	}

	public void setData(List<ParticipanteDTO> data) {
		this.data = data;
	}
}
