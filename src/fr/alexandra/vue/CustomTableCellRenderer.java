package fr.alexandra.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

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
    	
    	Font font1 = new Font("Arial", Font.PLAIN, 14);
    	
    	j.setHorizontalAlignment(JLabel.CENTER);// centre les données de ton tableau
    	j.setFont(font1);//applique le style font1
    	table.setRowHeight(30);
    	 					   			 
    	return j; 
  
    }
}
