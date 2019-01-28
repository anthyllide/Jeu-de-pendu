package fr.alexandra.vue;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent
       (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int column) 
    {
    	JLabel j = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, 
    			row, column); 
    			 
    	j.setHorizontalAlignment(JLabel.CENTER); 
    	j.setForeground(Color.red); 				   			 
    	return j; 
  
    }
}
