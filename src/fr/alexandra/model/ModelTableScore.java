package fr.alexandra.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModelTableScore extends AbstractTableModel {
	
	private int sizeMax;
    private Object[][] dataTable;
    
  //Les titres des colonnes
    String  titleTable[] = {"Pseudo", "Score", "Nombre de mots trouvés"};
    
    public ModelTableScore(ArrayList <String> scoreList) {
    	
    	super();
    	
    	this.sizeMax = scoreList.size();
    	this.dataTable = new Object[sizeMax][3];
    	
    	if(scoreList!= null) {
    	    
	    	for(int i = 0; i < scoreList.size(); i++) {
	    	   	
	    		Object[] items = scoreList.get(i).toString().split(",");
	    	    		
	    		dataTable[i][0] = items[0];
	    		dataTable[i][1] = items[1];
	    		dataTable[i][2] = items[2];			   	
	    			    		    	
	    	}
    	}
    }

	@Override
	public int getColumnCount() {
		return titleTable.length;
	}

	@Override
	public int getRowCount() {
		return dataTable.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return dataTable[rowIndex] [columnIndex];
	}
	
	public String getColumnName(int columnIndex) {
        return titleTable[columnIndex];
    }

}
