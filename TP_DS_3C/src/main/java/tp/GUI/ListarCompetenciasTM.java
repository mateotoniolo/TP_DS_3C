package tp.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.DTOs.CompetenciaDTO;




public class ListarCompetenciasTM extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CompetenciaDTO> data = new ArrayList<CompetenciaDTO>();
	private String[] columnNames = {"Nombre","Deporte","Modalidad","Estado"};
	
	public ListarCompetenciasTM() {
		
	}
	
	public void addItemTM(CompetenciaDTO item) {
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
		
		CompetenciaDTO temp = data.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return temp.getNombre();
		case 1:
			return temp.getDeporte().getNombre();
		case 2: 
			return temp.getModalidad().toString();
		case 3:
			return temp.getEstado().toString();
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
		this.data = new ArrayList<CompetenciaDTO>();
	}

	public List<CompetenciaDTO> getData() {
		return data;
	}

	public void setData(List<CompetenciaDTO> data) {
		this.data = data;
	}
}
