package tp.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.DTOs.ItemLugarDTO;
import tp.clases.ItemLugar;
import tp.clases.Lugar;




public class AltaCompetenciaTM extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ItemLugarDTO> data = new ArrayList<ItemLugarDTO>();
	private String[] columnNames = {"Codigo","Lugar","Disponibilidad"};
	
	public AltaCompetenciaTM() {
		
	}
	
	public void addItemTM(ItemLugarDTO item) {
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
		
		ItemLugarDTO temp = data.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return temp.getCodigo();
		case 1:
			return temp.getNombre();
		case 2: 
			return temp.getDisponibilidad();
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
		this.data = new ArrayList<ItemLugarDTO>();
	}

	public List<ItemLugarDTO> getData() {
		return data;
	}

	public void setData(List<ItemLugarDTO> data) {
		this.data = data;
	}
}
