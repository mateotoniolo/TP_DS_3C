package tp.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.DTOs.CompetenciaDTO;
import tp.DTOs.ItemLugarDTO;
import tp.DTOs.ParticipanteDTO;
import tp.clases.ItemLugar;
import tp.clases.Lugar;




public class ListarCompetenciasDeportivasTM extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CompetenciaDTO> data = new ArrayList<CompetenciaDTO>();
	private String[] columnNames = {"Nombre","Deporte","Modalidad","Estado"};
	
	public ListarCompetenciasDeportivasTM() {
		
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
			return temp.getId_deporte();
		case 2:
			return temp.getModalidad();
		case 3:
			return temp.getEstado();
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
