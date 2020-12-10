package bsu.rfe.java.group9.lab3.Kagal.varB6;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients)
    {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
        return 3;
    }
    public int getRowCount()
    {
    	if ( (to-from)*10 % 2 == 0 )
    		return new Double(Math.ceil((to-from)/step)).intValue()+1;
    	else 
    		 return new Double(Math.ceil((to-from)/step)).intValue();
    }
    public Object getValueAt(int row, int col) 
    {
        double x = from + step*row;
       
        double result = coefficients[0];
        
        for (int i = 1; i < coefficients.length; ++i)
            result = result * x + coefficients[i];

        switch(col) {
            case 0: {
                return x;
            }           
            case 1: {
                return result;
            }           
            case 2: {
                StringBuffer numberStr = new StringBuffer(String.valueOf((int)result));
                if(numberStr.toString().compareTo(numberStr.reverse().toString()) == 0)
                   return true;
                else return false;
            }
            default: return 0.0;
        }

    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:

                return "Значение X";
            case 1:

                return "Значение многочлена";

            case 2:
                return "Целая часть палиндром?";
            default:
                return "";
        }
    }
    public Class<?> getColumnClass(int col) {
       
        if (col == 2) return Boolean.class;
       
        else return Double.class;
    }
}