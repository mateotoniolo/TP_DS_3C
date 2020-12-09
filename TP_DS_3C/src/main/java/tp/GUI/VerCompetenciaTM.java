package tp.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import tp.DTOs.PartidoDTO;





public class VerCompetenciaTM extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PartidoDTO> data = new ArrayList<PartidoDTO>();
	private String[] columnNames = {"Visitante"," @ ","Local"};
	
	public VerCompetenciaTM() {
		
	}
	
	public void addItemTM(PartidoDTO item) {
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
		
		PartidoDTO temp = data.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return temp.getVisistante().getNombre();
		case 1:
			return "vs.";
		case 2: 
			return temp.getLocal().getNombre();
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
		this.data = new ArrayList<PartidoDTO>();
	}

	public List<PartidoDTO> getData() {
		return data;
	}

	public void setData(List<PartidoDTO> data) {
		this.data = data;
	}

	public void remove(PartidoDTO p) {
		this.data.remove(p);
		
	}

	public void removeAll() {
		this.data = null;
		this.data = new ArrayList<>();
		
	}
}
