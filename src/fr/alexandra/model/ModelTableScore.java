package fr.alexandra.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModelTableScore extends AbstractTableModel {
	
	private int sizeMax;
    private Object[][] dataTable;
    
  //Les titres des colonnes
    String  titleTable[] = {"Date","Pseudo", "Score (en points)", "Nb de parties"};
    
    public ModelTableScore(ArrayList <String> scoreList) {
    	
    	super();
    	
    	this.sizeMax = scoreList.size();
    	this.dataTable = new Object[sizeMax][4];
    	
    	//si l'arrayList des scores n'est pas vide
    	if(scoreList!= null) {
    	    
	    	for(int i = 0; i < scoreList.size(); i++) {
	    	   	
	    		Object[] items = scoreList.get(i).toString().split(",");
	    	    
	    		//on construit l'objet dataTable
	    		dataTable[i][0] = items[0];
	    		dataTable[i][1] = items[1];
	    		dataTable[i][2] = items[2];	
	    		dataTable[i][3] = items[3];	
	    			    		    	
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
